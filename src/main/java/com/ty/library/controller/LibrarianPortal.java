package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Book;
@WebServlet(value = "/libportal")
public class LibrarianPortal extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 String addBook=req.getParameter("insertBook");
	 String bookReturned=req.getParameter("addBook");
	 String bookIssued=req.getParameter("removeBook");
	 String bookHistory=req.getParameter("bookHistory");
	 
	 if(addBook!=null) {
		 RequestDispatcher requestDispatcher = req.getRequestDispatcher("insertBookInLibrary.jsp");
			requestDispatcher.forward(req, resp);
		 
	 }else
		 if(bookReturned!=null){
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookReturnPortal.jsp");
				requestDispatcher.forward(req, resp);
			 
			 
		 }else
			 if(bookIssued!=null){
				 RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookIssuePortal.jsp");
					requestDispatcher.forward(req, resp);
				 
			 }else
				 if(bookHistory!=null) {
					 RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookIssuePortal.jsp");
						requestDispatcher.forward(req, resp);
					  
					 System.out.println("Get all books in databse");
				 }else {
					 System.out.println("wrong choice");
				 }
 
 
     }
}
