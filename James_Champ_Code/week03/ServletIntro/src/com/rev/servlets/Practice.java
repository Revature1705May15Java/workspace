package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice
 */
public class Practice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Practice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName;
		String lastName;
		String gender;
		String[] hobbies; 
		String country;
		String[] langaugesKnown;
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> names = map.keySet();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Results of user input:</h3>");
		
		for(String p : names) {
			String[] values = map.get(p);
			out.println("<p>" + p + " : ");
			
			for(int i = 0; i < values.length; i++) {
				out.println(values[i] + " ");
			}
			
			out.println("</p>");
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
