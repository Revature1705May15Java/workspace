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
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String c = request.getParameter("country");
		String [] lang = request.getParameterValues("language");
		String [] hobby = request.getParameterValues("hobby");
	
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/**
		 * 
		 * FINISH!
		 */
		out.println("<div>");
		out.println("Username: "+userName);
		out.println("Password:" +pwd);
		out.println("Gender: "+ gender);
		out.println("Country "+c);
		for(String s: lang)
			{out.println("Language(s): "+ s);}
		for(String sx:hobby)
			{out.println("Hobbies: "+sx);}
		
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
