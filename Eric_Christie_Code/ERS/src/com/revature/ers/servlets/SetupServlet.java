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
 * Servlet implementation class SetupServlet
 */
public class SetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	  HttpSession session = request.getSession();
	  User u = (User) session.getAttribute("user");
	  if (u != null) {
	    boolean setupAttempted = false;
	    
	    String password = request.getParameter("pw");
	    String confirm = request.getParameter("cp");
	    
	    if (password != null || confirm != null) {
	      setupAttempted = true;
	    }
	    
	    if (password != null && confirm != null && !password.isEmpty() && !confirm.isEmpty()) {
	      setupAttempted = true;
	      
	      if (password.equals(confirm)) {
//	        System.out.println("passwords match");
	        boolean changed = service.changePassword(u, password);
	        if (changed) {
//	          System.out.println("change occurred, now redirecting");
	          response.sendRedirect("main");
	        } else {
//	          System.out.println("change was false");
	          request.setAttribute("setupAttempted", setupAttempted);
	          request.getRequestDispatcher("setup.ftl").forward(request, response);
	        }
        } else {
//          System.out.println("passwords did not match");
          request.setAttribute("setupAttempted", setupAttempted);
          request.getRequestDispatcher("setup.ftl").forward(request, response);
        }
	    } else {
//	      System.out.println("null or empty inputs");
	      request.setAttribute("setupAttempted", setupAttempted);
	      request.getRequestDispatcher("setup.ftl").forward(request, response);
	    }
    } else {
      response.sendRedirect("login");
    }
	}

}