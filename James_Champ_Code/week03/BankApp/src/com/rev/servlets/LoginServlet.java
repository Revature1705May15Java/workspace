package com.rev.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.User;
import com.rev.service.Service;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		
		Service service = new Service();
		
		User u = service.getUser(email);
		
		if(u != null && password.equals(u.getPassword())){
			request.setAttribute("user", u);
			request.getRequestDispatcher("member.ftl").forward(request, response);
		}
		else {
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("login.ftl").forward(request, response);
		}
	}
}
