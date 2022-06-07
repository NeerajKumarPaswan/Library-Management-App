package com.ty.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Book;
import com.ty.library.dto.Student;
import com.ty.library.service.BookService;
import com.ty.library.service.StudentService;
@WebServlet(value = "/bookissue")
public class BookIssueController extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   String studId=req.getParameter("studentId");
   String bookId=req.getParameter("bookId");
       
   int sid= Integer.parseInt(studId);
   int bid= Integer.parseInt(bookId);
   
   StudentService studentService=new StudentService();
   Student student=studentService.getStudentById(sid);
   
   BookService bookService=new BookService();  
   List<Book> book=bookService.getAllBooks();
  
   for(Book b:book) {
	   if(b.getId()==bid) {
		 
		   Book b1=bookService.getBookById(bid);
		  b1.setStudent(student);
		  
		  List<Book> b2=new ArrayList();
		  b2.add(b1);
		  
		  student.setBooks(b2);
		  boolean a=studentService.issueBookByStudentBook(student, b2);
		  if(a==true) {
			  RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuedSuccessfully.jsp");
		      requestDispatcher.forward(req, resp);
		  
		  }else {
			  System.out.println("Book not issued");
			   RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuePortal.jsp");
				requestDispatcher.forward(req, resp);
		  }
	   }
   }
   
   
   
    
 
//   if(a==true) {
//	   System.out.println("Book issued");
//	   RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuedSuccessfully.jsp");
//		requestDispatcher.forward(req, resp);
//
//   }else {
//	   System.out.println("Book not issued");
//	   RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuePortal.jsp");
//		requestDispatcher.forward(req, resp);
//
//   }
//   
  }

}
