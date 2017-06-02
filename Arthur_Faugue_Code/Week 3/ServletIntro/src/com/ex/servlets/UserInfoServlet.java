package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		out.println("<h3> Reading QueryString data usisng  'String firstname = request.getParameter(String name);' method</h3>");
		out.println("<div>");
		out.println("<p> First name = " + firstname + "</p>");
		out.println("<p> Last name = " + lastname + "</p>");
		out.println("</div>");
		
		/*
		 * from here we append values to the 
		 * url using [url]?[paramName]=[paramValue]&[paramName]=[paramValue]...
		 */
		
		out.println("<h3> Reading QuereyString data using"
				+ "Enumeration getParameterNames() method</h3>");
		
		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<div>");
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>"+ paramName +" : " + paramValue + "</p>");
		}
		out.println("</div>");
		//paste code here
		
		/*
		 * We can use any of the above methods to extract 
		 * parameter values from the URL, but the
		 * getParameter(String name) method is the 
		 * optimal one, as it allows you to specify parameters
		 */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
