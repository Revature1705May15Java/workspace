package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;

/**
 * Servlet implementation class SessionServlet for creating and destroying login sessions.
 * this servlet should also do some stuff with cookies and sessions:
 * - set a max inactive interval for each session
 * - (maybe do something with the creation time of each session)
 * - use cookies to keep track of each user's most recent login and logout times
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
   * TODO find a way to keep track of a user's last login and logout times without storing information in the database,
   * perhaps by using cookies or local storage
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
    HttpSession session = request.getSession(true);
    session.setMaxInactiveInterval(60 * 60);
	  boolean loginAttempted = false;
	  
	  if (((User) session.getAttribute("user")) != null) {
      response.sendRedirect("main");
    } else {
      String email = request.getParameter("em");
      String password = request.getParameter("pw");
      
      if (email != null || password != null) {
        loginAttempted = true;
      }
      
      if (email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
        loginAttempted = true;
        User result = service.login(email, password);
        
        if (result != null) {
          session.setAttribute("user", result);
          if (result.isSetupDone()) {
            response.sendRedirect("main");
          } else {
            response.sendRedirect("setup");
          }
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

}
