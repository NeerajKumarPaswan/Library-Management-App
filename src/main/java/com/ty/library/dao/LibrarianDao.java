package com.ty.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.library.dto.Librarian;

public class LibrarianDao {

	public Librarian createLibrarian(Librarian librarian) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(librarian);
		entityTransaction.commit();
		return librarian;
	}

	public boolean removeLibrarianById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Librarian librarian = entityManager.find(Librarian.class, id);
		if (librarian != null) {
			entityTransaction.begin();
			entityManager.remove(librarian);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}

	}
}
