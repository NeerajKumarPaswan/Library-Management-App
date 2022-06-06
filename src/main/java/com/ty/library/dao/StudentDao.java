package com.ty.library.dao;

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
	
	public boolean issueBookByStudentBook(Student student,Book book) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        if(student!=null && book!=null) {  
		entityTransaction.begin();
		entityManager.merge(student);
		entityManager.merge(book);
		
		entityTransaction.commit();
        return true;
        }else {
        	return false;	
        }
		
	}
	
	public boolean returnBookByStudentBookId(Student student,Book book) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        if(student!=null && book!=null) {  
        	   Student s= book.getStudent();
        	  System.out.println(s.getName());
		
        	entityTransaction.begin();
		   entityManager.merge(book);
		  System.out.println("Reaching");
		   entityTransaction.commit();
		return true;
	}else {
		return false;
	}
	}
}
