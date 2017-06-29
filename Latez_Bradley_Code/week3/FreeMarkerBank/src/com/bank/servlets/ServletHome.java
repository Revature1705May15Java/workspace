package com.bank.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.Account;
import com.bank.pojos.User;

/**
 * Servlet implementation class ServletHome
 */
//@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HOME SERVLET RUNNING");
		User u = new User();
		HttpSession s = request.getSession(true);
		
		u = (User)s.getAttribute("user");
		
		String fName = u.getFn();
		String lName = u.getLn();
		ArrayList<Account> a = new ArrayList<Account>();
		
		a = u.getUserAccounts();
		System.out.println(fName);
		System.out.println(lName);
		
		
		request.setAttribute("firstname", fName);
		request.setAttribute("lastname", lName);
		request.setAttribute("accounts", a);
		
		request.getRequestDispatcher("/home.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
