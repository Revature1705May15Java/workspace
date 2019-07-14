package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String[] habbit = request.getParameterValues("habbit");
		String country = request.getParameter("country");
		String[] languages = request.getParameterValues("languages");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<div>");
		out.print("<p>Username " + username + "</p>");
		out.print("<p>Password " + password + "</p>");
		out.print("<p>gender "+ gender + "</p>");
		for(int i = 0; i < habbit.length;i++){
			out.print("<p>hobbit "+ habbit[i] + "</p>");
		}
		out.print("<p>country "+ country + "</p>");
		for(int i = 0; i < languages.length;i++){
			out.print("<p>language "+ languages[i] + "</p>");
		}
		
		out.print("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
