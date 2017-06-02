package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojo.User;
import com.bank.service.Service;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/login")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Service serv = new Service();
	public User u = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		try{
			u = serv.getUser(username, password);
			if(!u.getFn().isEmpty()){//if empty then fail
				HttpSession s = request.getSession(true);
				s.setAttribute("user", u);//stores name and object when you retrieve you cast back
				response.sendRedirect("home");//take response and send to an action to servlet(home is defined in web.x)
//				RequestDispatcher rd = request.getRequestDispatcher("Success.html");
//				rd.forward(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("Error.html");
				rd.forward(request, response);
			}
		}catch(NullPointerException e){
			response.sendRedirect("Error.html");
		}
//		doGet(request, response);
	}

}
