package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		
		out.println("<h3>Reading QueryString data using String getParameter(String s) method:</h3>");
		out.println("<div>");
		out.println("<p>First Name: " + firstName + ".</p>");
		out.println("<p>Last Name: " + lastName + ".</p>");
		out.println("</div>");
		
		out.println("<h3>Reading QueryString data using Enumeration getParameterNames() method.</h3>");
		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<div>");
		
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>Parameter name: " + paramName + "<br>Value: " + paramValue + "</p>");
		}
		out.println("</div>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNameSet = paramMap.keySet();
		
		out.println("<h3>Read QueryString data using Map getParameterMap() method:</h3>");
		out.println("<div>");
		for(String p : paramNameSet) {
			String[] paramValues = paramMap.get(p);
			out.println("<p>" + p + " : ");
			
			for(int i = 0; i < paramValues.length; i++) {
				out.println(paramValues[i]);
			}
			
			out.println("</p>");
		}
		out.println("</div");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
