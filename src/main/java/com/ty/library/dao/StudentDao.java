package com.ty.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.library.dto.Book;
import com.ty.library.dto.Student;

public class StudentDao {

	public Student createStudent(Student student) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
	public Student getStudentById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager.find(Student.class, id);
	}
	
	public boolean issueBookByStudentBook(Student student,List <Book> book) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for(Book b:book) {
			if(student!=null && b!=null) {  
				entityTransaction.begin();
				entityManager.merge(student);
				entityManager.merge(b);
				entityTransaction.commit();
		        
			}
		return true;	       
		}
		return false;
		}
	
	public boolean returnBookByStudentBookId(Student student,List <Book> book) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		for(Book b: book) {
			if(b!=null && student!=null) {
				
			//b.setStudent(null);
			entityTransaction.begin();
			entityManager.merge(b);
			entityManager.merge(student);
			entityTransaction.commit();
				System.out.println("Returned");
			} 
		return true;
	} 
	         return false;
	
	}
}
