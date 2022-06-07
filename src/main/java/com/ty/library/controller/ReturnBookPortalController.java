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
      List<Book> books=bookService.getAllBooks();
      for(Book b:books) {
    	  if(b.getId()==bkid) {
    		  
    		  Book b1=bookService.getBookById(bkid);
    		  b1.setStudent(null);
    	
    		  List<Book> b2=new ArrayList();
              b2.add(b1);
              
              student.setBooks(b2);
              boolean a=studentService.returnBookByStudentBookId(student, b2);
              if(a==true) {
            	  RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookReturned.jsp");
					requestDispatcher.forward(req, resp);
				 
              }else {
            	  RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookReturnPortal.jsp");
					requestDispatcher.forward(req, resp);
				 
              }
         	
    	  }
      }
      
	}

}
