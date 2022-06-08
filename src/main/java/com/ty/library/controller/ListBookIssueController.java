package com.ty.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Book;
import com.ty.library.service.BookService;
@WebServlet(value = "/issue")
public class ListBookIssueController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id+ "is your book id");
		int bid=Integer.parseInt(id);
		System.out.println(bid);
		if(bid!=0) {
			req.setAttribute("myid", bid);
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentIdIdentification.jsp");
				requestDispatcher.forward(req, resp);
		}
//        BookService bookService=new BookService();
//	 List<Book>books= bookService.getAllBooks();
//		
//	 for(Book b:books) {
//			if(  b.getId()==id && b.getStudent()==null) {
//				req.setAttribute("myid", id);
//				 RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentIdIdentification.jsp");
//					requestDispatcher.forward(req, resp);
//				  
//			}
//	 }
	 }
	}

