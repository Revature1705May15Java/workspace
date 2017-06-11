package com.revature.ers.servlets;

import java.io.IOException;

//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;

/**
 * Servlet implementation class SessionServlet
 * for creating and destroying login sessions.
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * - need to rethink this approach of having login and logout both map to this servlet
   * - considering using cookies or local storage to keep track of a user's last login and logout
	 */
	

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
	  ERService service = new ERService();
	  boolean loginAttempted = false;
	  
    String email = request.getParameter("em");
    String password = request.getParameter("pw");
    
    if (email != null || password != null) {
      loginAttempted = true;
    }
    
    if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
      loginAttempted = true;
      User result = service.login(email, password);
      
      if (result != null) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", result);
        response.sendRedirect("main");
      } else {
        request.setAttribute("loginAttempted", loginAttempted);
        request.getRequestDispatcher("login.ftl").forward(request, response);
      }
    } else {
      request.setAttribute("loginAttempted", loginAttempted);
      request.getRequestDispatcher("login.ftl").forward(request, response);
    }
	  
	}

}
