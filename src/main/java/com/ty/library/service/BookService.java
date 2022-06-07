package com.ty.library.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.library.dao.BookDao;
import com.ty.library.dto.Book;
import com.ty.library.dto.Student;

public class BookService {
BookDao bookDao=new BookDao();
	public Book saveBook(Book book) {
	
	  return bookDao.saveBook(book);
	}
	
public Book getBookById(int id) {
		
		return bookDao.getBookById(id);
	}
public List<Book> getAllBooks() {
	return bookDao.getAllBooks();
}

}
