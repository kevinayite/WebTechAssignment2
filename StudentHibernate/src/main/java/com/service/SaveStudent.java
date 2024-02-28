package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.StudentDao;
import com.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/register")
public class SaveStudent extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String studId = req.getParameter("studentId");
		String prenom = req.getParameter("firstName");
		String nom = req.getParameter("lastName");
		String department = req.getParameter("department");
		String faculty = req.getParameter("faculty");
		
		
		if(studId != null && prenom != null && nom != null && department != null && faculty != null) {
			StudentDao studentSave = new StudentDao();
			Student newStudent = new Student(studId,prenom, nom, department, faculty);
			studentSave.registerStudent(newStudent);
			res.sendRedirect("displayStudents");
		}else {
			PrintWriter out = res.getWriter();
			out.println("Fill each fields");
		}
		
		
		
		
		
	}

}
