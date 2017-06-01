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
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String hobbies = request.getParameter("hobbies");
		String hobbies1 = request.getParameter("hobbies1");
		String hobbies2 = request.getParameter("hobbies2");
		String country = request.getParameter("countries");
		String [] languages = request.getParameterValues("languages");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Username: " + userName + "<br>");
		out.println("Password: " + password + "<br>");
		out.println("Gender: " + gender + "<br>");
		out.println("Hobbies: " + hobbies + " " + hobbies1 + " " + hobbies2 + "<br>");
		out.println("Country: " + country + "<br>");
		for(String l : languages){
			out.println(l.toString() + " ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
