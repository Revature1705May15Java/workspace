package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		String myContextPara = request.getSession().getServletContext().getInitParameter("myParam");
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		out.println(myContextPara  +" " + name + " " + pw );
		if(name.equals("lee")){
			response.sendRedirect("user.html");
		}
		else{
			response.sendRedirect("error.html");
		}
		
	}
}
