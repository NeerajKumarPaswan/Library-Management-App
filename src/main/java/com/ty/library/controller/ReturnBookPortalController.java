package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Book;
import com.ty.library.dto.Student;
import com.ty.library.service.BookService;
import com.ty.library.service.StudentService;

@WebServlet(value = "/returnBook")
public class ReturnBookPortalController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String bookId= req.getParameter("bookId");
      String studId= req.getParameter("studentId");
      
      int stid= Integer.parseInt(studId);
      int bkid= Integer.parseInt(bookId);
      
      StudentService studentService=new StudentService();
      Student student=studentService.getStudentById(stid);
      
      BookService bookService=new BookService();  
      Book book=bookService.getBookById(bkid);
     
      book.setStudent(student);
      student.setBooks(book);
	
     boolean a=  studentService.returnBookByStudentBookId(student, book);
     if(a==true) {
    	 System.out.println("book returned");
     }else {
    	 System.out.println("Book or student not found");
     }
	}

}
