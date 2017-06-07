package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User();
		Service service = new Service();
		request.setAttribute("Login", "-");
		
		try{
			u = service.getUser(username);
			HttpSession session = request.getSession(true);
			
			if(u != null && u.getPassword() != null && u.getPassword().equals(password)){
				
				if(u != null) System.out.println(u.toString());
				session.setAttribute("user", u);
				response.sendRedirect("home");
				
			} else {
				System.out.println("In login else");
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("login.ftl").forward(request, response);;
			}		
			
		} catch(NullPointerException npe){
			//response.sendRedirect("Error.html");
			PrintWriter out = response.getWriter();
			out.println("Catch error :/");
			
		}
	}
	
}
