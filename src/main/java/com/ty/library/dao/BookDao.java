package com.ty.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.library.dto.Book;

public class BookDao {
	public Book saveBook(Book book) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
		
		return book;
	}
	
	public Book getBookById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager.find(Book.class, id);
	}
	
	public List<Book> getAllBooks() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql="SELECT b FROM Book b";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
	}

}
