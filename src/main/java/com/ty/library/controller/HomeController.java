package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/home")
public class HomeController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		String admin=req.getParameter("admin");
		String librarian=req.getParameter("librarian");
		String student=req.getParameter("student");
		
		if(admin!=null) {
			System.out.println("admin");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(req, resp);

		}else
			if(librarian!=null) {
				System.out.println("lib");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("liblogin.jsp");
				requestDispatcher.forward(req, resp);

			}else
				if(student!=null){
					System.out.println("stud");
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("admin.jsp");
					requestDispatcher.forward(req, resp);

				}
		
	
	}
}
