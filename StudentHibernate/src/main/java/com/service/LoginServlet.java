package com.service;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String mail = req.getParameter("email");
		String secret = req.getParameter("password");
		
		

		if(mail.equals("kevinayikson14@gmail.com") && secret.equals("kevin1234") ) {
			
			res.sendRedirect("register.html");
		}else {
			res.sendRedirect("forgot.html");
		}
		
	}

}
