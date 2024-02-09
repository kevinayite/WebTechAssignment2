package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDao;
import jakarta.servlet.annotation.WebServlet;
import model.Student;

@WebServlet("/")
public class FunctionalityServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doGet(request, response);
		    }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        String action = request.getServletPath();
			    
			        try {
			            switch (action) {
			                case "/new":
			                    showNewForm(request, response);
			                    break;
			                case "/insert":
			                    insertStudent(request, response);
			                    break;
			                case "/delete":
			                    deleteStudent(request, response);
			                    break;
			                case "/edit":
			                    showEditForm(request, response);
			                    break;
			                case "/update":
			                    updateStudent(request, response);
			                    break;
			                default:
			                    displayStudents(request, response);
			                    break;
			            }
			        } catch (SQLException ex) {
			            throw new ServletException(ex);
			        }
	 }

	    private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
	    		throws SQLException, IOException{
		// TODO Auto-generated method stub
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String department = request.getParameter("department");
			String faculty = request.getParameter("faculty");
			
			Student theStudent = new Student( id, firstName, lastName, department, faculty);
			
			studentDao.registerStudent(theStudent);
			response.sendRedirect("list");
		
	}
		private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException{
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
	        studentDao.deleteStudent(id);
	        response.sendRedirect("list");
		
	}
		
		
		
		private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException{
		// TODO Auto-generated method stub
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String department = request.getParameter("department");
			String faculty = request.getParameter("faculty");
			
			Student theStudent = new Student( null, firstName, lastName, department, faculty);
			
			studentDao.registerStudent(theStudent);
			response.sendRedirect("list");
		
	}
		
		
		
		private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
	    		throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
	    	 RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	         dispatcher.forward(request, response);
		
	}
		
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
	    		throws SQLException, IOException, ServletException {
	    	
		// TODO Auto-generated method stub
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	        dispatcher.forward(request, response);
		
	}
		
		
		private void displayStudents(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	        List < Student > displayStudents = studentDao.AllStudents();
	        request.setAttribute("studentList", displayStudents);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	        dispatcher.forward(request, response);
	    }

	

}
