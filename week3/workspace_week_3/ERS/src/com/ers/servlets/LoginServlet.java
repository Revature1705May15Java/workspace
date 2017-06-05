package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String myContextParam = request.getSession().getServletContext().getInitParameter("myParam");
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		
		
		if(name.equals("Lei") && pw.equals("Raion")){
			response.sendRedirect("Home.html");
		} else if(name.equals("test") && pw.equals("test")){
			response.sendRedirect("Home2.html");
		} else{
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("index.ftl").forward(request, response);
		}
		
		
	}

}