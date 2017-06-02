package com.rev.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.User;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ArrayList<User> userList = new ArrayList<User>();
	
	static {
		userList.add(new User("First", "Last"));
		userList.add(new User("Betty", "Bobettie"));
		userList.add(new User("Fran", "McMann"));
		userList.add(new User("Tom", "Bobbom"));
		userList.add(new User("Jules", "Rules"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Puts userList into the request and lets freemarker display it to the view
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		
		if(fname != null && lname != null && !fname.isEmpty() && !lname.isEmpty()) {
			synchronized(userList) {
				userList.add(new User(fname, lname));
			}
		}
		
		doGet(request, response);
	}

}
