package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Book;
import com.ty.library.service.BookService;

@WebServlet(value = "/addBook")
public class AddBookInLibrary extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
		String bookName=req.getParameter("bookName");
		String bookAuthor=req.getParameter("bookAuthor");
		String bookGenre=req.getParameter("bookGenre");
		
		Book book=new Book();
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		book.setBookGenre(bookGenre);
		
		BookService bookService=new BookService();
		Book b=	bookService.saveBook(book);
		
		if(b!=null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("bookAddedSuccessfully.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("insertBookInLibrary.jsp");
			requestDispatcher.forward(req, resp);
		}
	
	}

}
