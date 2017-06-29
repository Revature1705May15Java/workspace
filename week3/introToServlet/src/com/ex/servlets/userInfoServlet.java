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
 * Servlet implementation class userInfoServlet
 */
@WebServlet("/userInfoServlet")
public class userInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //THIS IS OUR NEW PUBLIC STATIC VOID MAIN(STRING [] ARGS!!!!!!!!!!!!) 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	// Default value	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		
		out.println("<h3> Reading QueryString Data using String getParameter(String name)' method </h3>");
		out.println("<div>");
		out.println("<p> First name: "+ firstname +"</p>");
		out.println("<p> Last name: "+ lastname +"</p>");
		out.println("</div>");
		/**
		 * From here, we appened parameter values to the
		 * url using.... http://localhost:8081/introToServlet/userInfoServlet?fn=Genesis&ln=Bonds
		 */
		out.println("<h3> Reading QueryStrubg data using"
				+ " Enumeration getParameters()' method</h3>");
		
		Enumeration<String> paramNames = request.getParameterNames();
		
		out.println("<div>");
		
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>"+ paramName+" : "+paramValue+"</p>");
		}
		out.println("</div>");
		
		/*\
		 * GET PARAM MAP METHOD
		 */
		
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNameSet = paramMap.keySet();
		
		out.println("<h3>Read QueryString data using Map getParameterMap() method </h3>");
		out.println("</div>");
		for(String paramName: paramNameSet){
			String[] paramValues = paramMap.get(paramName);
			out.println("<p> "+ paramName+": ");
			for(int i=0;i< paramValues.length;i++){
				out.println(paramValues[i]);
			}
			//out.prin
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}