package com.ty.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.library.dto.Student;
import com.ty.library.service.StudentService;
@WebServlet(value = "/student")
public class StudentController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("studName");
       String phone=req.getParameter("studPhone");
       String email=req.getParameter("studEmail");
       String password=req.getParameter("studPassword");
       
       Student student=new Student();
       student.setName(name);
       student.setPhone(phone);
       student.setEmail(email);
       student.setPassword(password);
       
       StudentService studentService=new StudentService();
       Student s=studentService.createStudent(student);
	     if(s!=null) {
	    	 RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentCreatedSuccessfully.jsp");
	 		requestDispatcher.forward(req, resp);

	     }else {
	    	 RequestDispatcher requestDispatcher = req.getRequestDispatcher("createStudent.jsp");
		 		requestDispatcher.forward(req, resp);

	     }
	}
}
