package com.ty.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/admin")
public class AdminLoginValidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("adminId");
		String password = req.getParameter("adminPassword");

		String adminId = "1039";
		String adminPassword = "1234";
		PrintWriter printWriter = resp.getWriter();
		
		
		if (id.equals(adminId) && password.equals(adminPassword)) {
			System.out.println("admin successfully loggedin");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminchoice.jsp");
			requestDispatcher.forward(req, resp);

		} else {
			printWriter.write("<html><body><h1> Invalid Admin Credential </h1></body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin.jsp");
			requestDispatcher.include(req, resp);

		}

	}

}
