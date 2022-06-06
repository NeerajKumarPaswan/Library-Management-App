package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/adminchoice")
public class AdminChoice extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      String createLibrarian=req.getParameter("createLibrarian");
	      String createStudent=req.getParameter("createStudent");
	      if(createLibrarian!=null) {
	    	  System.out.println("Librarian console promoted");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminLoggedIn.jsp");
				requestDispatcher.forward(req, resp);

	      }
	      else if(createStudent!=null)
	      {
	    	  System.out.println("Student console promoted");
	    	  RequestDispatcher requestDispatcher = req.getRequestDispatcher("createStudent.jsp");
				requestDispatcher.forward(req, resp);
	      }
	      
	}

}
