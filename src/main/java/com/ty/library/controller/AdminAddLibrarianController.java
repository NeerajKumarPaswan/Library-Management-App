package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Librarian;
import com.ty.library.service.LibrarianService;

@WebServlet(value = "/librarian")
public class AdminAddLibrarianController extends HttpServlet{
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("libName");
		String phone = req.getParameter("libPhone");
		String email = req.getParameter("libEmail");
		String password = req.getParameter("libPassword");

       Librarian librarian=new Librarian();
       librarian.setName(name);
       librarian.setPhone(phone);
       librarian.setEmail(email);
       librarian.setPassword(password);
       
	   LibrarianService librarianService=new LibrarianService();
	  Librarian l1= librarianService.createLibrarian(librarian);
	if(l1!=null) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarianCreated.jsp");
		requestDispatcher.forward(req, resp);

	}else {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("librarianNotCreated.jsp");
		requestDispatcher.forward(req, resp);

	}
	}

}
