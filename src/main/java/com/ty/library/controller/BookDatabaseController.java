package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/bookdatabase")
public class BookDatabaseController extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
	 String db=req.getParameter("bookHistory");
	 
	 if(db!=null) {
		 System.out.println("All good");
	 }
 
    }
}
