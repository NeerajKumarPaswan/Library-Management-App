package com.ty.library.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.library.dao.StudentDao;
import com.ty.library.dto.Book;
import com.ty.library.dto.Student;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	public Student createStudent(Student student) {
		
		return studentDao.createStudent(student);
		
	}
   
	public Student getStudentById(int id) {
		
		return studentDao.getStudentById(id);
	}
	
	public boolean issueBookByStudentBook(Student student,Book book) {
		return studentDao.issueBookByStudentBook(student, book);
		
	}
	public boolean returnBookByStudentBookId(Student student,Book book) {
		return studentDao.returnBookByStudentBookId(student, book);
	}
}
