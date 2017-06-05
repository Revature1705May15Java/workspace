package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.setAttribute("login","fail");
		request.getRequestDispatcher("login.ftl").forward(request, response);
		

	}
	
	
	

}
