package com.ty.library.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.library.dao.LibrarianDao;
import com.ty.library.dto.Librarian;

public class LibrarianService {
	LibrarianDao librarianDao = new LibrarianDao();
//to create librarian
	public Librarian createLibrarian(Librarian librarian) {
		return librarianDao.createLibrarian(librarian);
  }
//to delete librarian
	public boolean removeLibrarianById(int id) {
	return librarianDao.removeLibrarianById(id);
	}
}
