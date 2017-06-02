package com.ex.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<User> userList = new ArrayList<User>();

	static{
		userList.add(new User("Bill", "Gates"));
		userList.add(new User("test", "test"));
		userList.add(new User("Genesis", "Bonds"));
		userList.add(new User("hello", "world"));
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Put the user list in request and 
		//let freemarker paint it.
		request.setAttribute("users", userList);
		
		request.getRequestDispatcher("/index.ftl").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		if(null != firstname && null != lastname
				&& !firstname.isEmpty() && !lastname.isEmpty()) {
			
			synchronized (userList) {
				userList.add(new User(firstname, lastname));
			}
			
		}
		
		doGet(request, response);
	}
}
