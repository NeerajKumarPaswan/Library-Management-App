package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/liblogin")
public class LibrarianLoginValidation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
	String id=req.getParameter("libId");
	String password=req.getParameter("libPassword");
	
	if(id.equals("1")&&password.equals("1234")) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarianHome.jsp");
		requestDispatcher.forward(req, resp);

	}else
	{
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("liblogin.jsp");
		requestDispatcher.forward(req, resp);

	}
	
	
	}

}
