package com.ty.library.controller;

import java.io.IOException;

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
   Book book=bookService.getBookById(bid);
   book.setStudent(student);
   student.setBooks(book);
   
   boolean a=studentService.issueBookByStudentBook(student, book);
   if(a==true) {
	   System.out.println("Book issued");
	   RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuedSuccessfully.jsp");
		requestDispatcher.forward(req, resp);

   }else {
	   System.out.println("Book not issued");
	   RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookIssuePortal.jsp");
		requestDispatcher.forward(req, resp);

   }
   
  }

}
