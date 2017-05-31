package com.ex.servlets;

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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	  response.setContentType("text/html");
	  
	  PrintWriter out = response.getWriter();
    
    String firstname = request.getParameter("fn");
    String lastname = request.getParameter("ln");
    
    out.println("<h3>Reading QueryString data using 'String getParameter(String name)' method: </h3>");
    out.println("<div>");
    out.println("<p>First name: " + firstname + "</p>");
    out.println("<p>Last name: " + lastname + "</p>");
    out.println("</div>");
	  /*
	   * from here we appent parameter values to the url using querystring syntax
	   * [url]?[paramName1]=[paramValue1]&[paramName2]=[paramValue2]
	   */
    
    out.println("<h3>Reading QueryString data using 'Enumeration getParameterNames(String name)' method: </h3>");
    Enumeration<String> paramNames = request.getParameterNames();
    out.println("<div>");
    while (paramNames.hasMoreElements()) {
      String paramName = paramNames.nextElement();
      String paramValue = request.getParameter(paramName);
      out.println("<p>" + paramName + ": " + paramValue + "</p>");
    }
    out.println("</div>");
    
    
    Map<String, String[]> paramMap = request.getParameterMap();
    Set<String> paramNameSet = paramMap.keySet();
    out.println("<h3>Reading QueryString data using 'Map<String, String[]> getParameterMap(String name)' method: </h3>");
    out.println("<div>");
    for (String paramName: paramNameSet) {
      String[] paramValues = paramMap.get(paramName);
      out.println("<p>" + paramName + ": ");
      for (int i = 0; i < paramValues.length; i++) {
        out.println(paramValues[i]);
      }
      out.println("</p>");
    }
    out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
