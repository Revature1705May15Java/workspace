package com.ex.servlets;

import java.io.IOException;

//import javax.servlet.Servlet;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojos.User;
import com.ex.service.BankingService;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean loginAttempted = false;
	private User currentUser = null;
	

//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//	  super.init(config);
//	}
//
//	/**
//	 * @see Servlet#destroy()
//	 */
//	public void destroy() {
//	  super.destroy();
//	}
//
//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	  System.out.println("service");
//	  super.service(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  
	  String email = request.getParameter("em");
	  String password = request.getParameter("pw");
	  
	  BankingService service = new BankingService();
	  
	  if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
	    loginAttempted = true;
      currentUser = service.loginUser(email, password);
    } else if (email != null || password != null) {
      loginAttempted = true;
    } else {
      loginAttempted = false;
    }
	  
    if (currentUser == null) {
      request.setAttribute("loginAttempted", loginAttempted);
      request.getRequestDispatcher("login.ftl").forward(request, response);
    } else {
      HttpSession session = request.getSession(true);
      session.setAttribute("user", currentUser);
      request.getRequestDispatcher("home.ftl").forward(request, response);
//      response.sendRedirect("home.ftl");
    }
	}

}
