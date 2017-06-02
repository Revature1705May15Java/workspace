package com.ex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojo.User;


//@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getRequestDispatcher("/login.ftl");
		User u = new User();
		System.out.println("here");
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		
		String firstName = u.getFn();
		String lastName = u.getLn();
		
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		
		System.out.println(u.getFn() + " loged in");
		request.getRequestDispatcher("/login.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User u = new User();
//		System.out.println("hereeeqe");
//		HttpSession s = request.getSession(true);
//		
//		u = (User) s.getAttribute("user");
//		
//		String firstName = u.getFn();
//		String lastName = u.getLn();
//		
//		request.setAttribute("firstname", firstName);
//		request.setAttribute("lastname", lastName);
//		
//		System.out.println(u.getFn() + " loged in");
//		doGet(request, response);
	}

}
