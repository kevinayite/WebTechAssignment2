package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.StudentDao;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/DeleteServlet")
public class DeleteStudent extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String studId = req.getParameter("studentId");
		
		
		
		if(studId != null ) {
			StudentDao studentDelete = new StudentDao();
			
			studentDelete.deleteStudent(studId);
			res.sendRedirect("displayStudents");
		}else {
			PrintWriter out = res.getWriter();
			out.println("Fill each fields");
		}
		
		
		
		
		
	

	}


}
