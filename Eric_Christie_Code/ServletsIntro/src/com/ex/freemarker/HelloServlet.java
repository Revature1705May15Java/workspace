package com.ex.freemarker;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.User;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private static ArrayList<User> userList = new ArrayList<>();
	
	static {
	  userList.add(new User("Person", "One"));
    userList.add(new User("Person", "Two"));
    userList.add(new User("Person", "Three"));
    userList.add(new User("Person", "Four"));
    userList.add(new User("Person", "Five"));
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("init");
	  super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	  System.out.println("destroy");
	  super.destroy();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("service");
	  super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  /*
	   * put the users ArrayList into the request and let freemarker display it in the view
	   */
	  request.setAttribute("users", userList);
	  request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		
		if (firstname != null && lastname != null && !firstname.isEmpty() && !lastname.isEmpty()) {
		  synchronized (userList) {
		    userList.add(new User(firstname, lastname));
		  }
		}
		
		doGet(request, response);
	}

}
