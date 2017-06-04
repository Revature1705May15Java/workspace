package com.ex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojo.User;
import com.bank.service.Service;


//@WebServlet("/login")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Service serv = new Service();
	public User u = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("index.html").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		HttpSession s = request.getSession(true);
		u = serv.getUser(username, password);
		try{
			
			if(!u.getFn().isEmpty()){//if empty then fail
				u.setUserAccounts(serv.showAccounts(u.getId()));
				s.setAttribute("user", u);//stores name and object when you retrieve you cast back
				response.sendRedirect("home");//take response and send to an action to servlet(home is defined in web.x)
			}
		}catch(NullPointerException e){
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("boss.ftl").forward(request, response);
//			response.sendRedirect("Error.html");
		}
//		doGet(request, response);
	}

}
