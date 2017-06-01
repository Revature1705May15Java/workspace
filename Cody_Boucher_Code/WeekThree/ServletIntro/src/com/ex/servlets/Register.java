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
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String[] sport = request.getParameterValues("sport");
		String team = request.getParameter("team");
		String[] position = request.getParameterValues("position");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Username: " + username);
		out.println("Password: " + password);
		out.println("Gender: " + gender);
		out.println("Sport: ");
		for(String str : sport) {
			out.println("\t" + str);
		}
		out.println("\tTeam: " + team);
		out.println("Positions: ");
		for(String str : position) {
			out.println("\t" + str + " ");
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
