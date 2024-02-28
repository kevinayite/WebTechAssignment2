package com.service;

import java.io.IOException;
import java.util.List;

import com.dao.StudentDao;
import com.model.Student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/displayStudents")
public class AllStudents extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws ServletException, IOException {
	      
	    // Get students from DAO  
	    StudentDao dao = new StudentDao();
	    List<Student> students = dao.getAllStudents();
	    
	    // Generate HTML
	    String html = "<html>";
	    
	    //html += "<body>";
	    html += "<body style='text-align: center'>";
	    html +="<br><br>";
	    html +="<br><br>";
	    html += "<table border='1'>";
	    html += "<tr>";
	    html += "<th>Student ID</th>";
	    html += "<th>First Name</th>";
	    html += "<th>Last Name</th>";
	    html += "<th> Faculty</th>";
	    html += "<th> Department</th>";
	    html += "</tr>";
	    
	    for(Student s : students) {
	      html += "<tr>";
	      html += "<td>" + s.getId() + "</td>";
	      html += "<td>" + s.getFirstName() + "</td>";
	      html += "<td>" + s.getLastName() + "</td>";
	      html += "<td>" + s.getFaculty() + "</td>";
	      html += "<td>" + s.getDepartment() + "</td>";
	      html += "</tr>"; 
	      
	    }
	    
	    html += "</table>";
	    html +="<br><br>";
	    html += "<button onclick='location.href=\"register.html\"'>Go to Previous Page</button><br><br>";
	    html += "</body>"; 
	    html += "</html>";
	    
	    // Print HTML
	    response.setContentType("text/html");
	    response.getWriter().print(html);

	  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		doGet(request,response);
		
	}


}
