package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		
		Service service = new Service();
		HttpSession session = request.getSession();
		request.setAttribute("login", "stuff");
		try{

			boolean isUser=service.checkPassword(pass, username);
			User u=service.findUser(username);
			if(isUser){
				
				session.setAttribute("user", u);
				response.sendRedirect("home");
				session.setAttribute("login", "success");
			}else{
				session.setAttribute("login", "fail");
				request.getRequestDispatcher("login.ftl").forward(request, response);
			}
			
		}catch(NullPointerException npe){
			response.sendRedirect("Error.html");
		}
	}

}
