package com.revature.ers.servlets;

import java.io.IOException;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.Employee;
import com.revature.ers.service.ExpenseReimbursementService;

/**
 * Servlet implementation class SessionServlet
 * for creating and destroying login sessions.
 */
//@WebServlet("/LoginServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  private boolean loginAttempted = false;

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
	  String uri = request.getRequestURI();
	  ExpenseReimbursementService service = new ExpenseReimbursementService();
	  
	  if (uri.equals("/ERS/login")) {
	    String email = request.getParameter("em");
	    String password = request.getParameter("pw");
	    
	    if (email != null || password != null) {
	      loginAttempted = true;
	    }
	    
	    if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
	      loginAttempted = true;
	      Employee result = service.login(email, password);
	      
	      if (result != null) {
	        HttpSession session = request.getSession(true);
	        session.setAttribute("employee", result);
	        request.getRequestDispatcher("main.ftl").forward(request, response);
//	        response.sendRedirect("main.ftl");
	      }
	    }
	  } else if (uri.equals("/ERS/logout")) {
	    HttpSession session = request.getSession();
	    if (session.getAttribute("employee") != null) {
	      service.logout((Employee) session.getAttribute("employee"));
	    }
	    request.getSession().invalidate();
	  }
	  
	  request.setAttribute("loginAttempted", loginAttempted);
    request.getRequestDispatcher("login.ftl").forward(request, response);
	}

}
