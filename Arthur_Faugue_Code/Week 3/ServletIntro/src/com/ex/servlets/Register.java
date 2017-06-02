package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");

		String sex = request.getParameter("gender");
		String[] hob = request.getParameterValues("hobbies");

		String origin = request.getParameter("state");
		String[] lang = request.getParameterValues("language");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<div>");
		out.println("<p>Username: " + username + "</p>");
		out.println("<p>Password: " + password + "</p>");
		out.println("</div>");

		out.println("<div>");
		out.println("<p>Gender: " + sex + "</p>");
		out.println("</div>");

		out.println("<div>");
		out.println("<p>Hobbies: </p>");
		try {
			for (String element : hob) {
				out.println("<p>" + element + "</p>");
			}
		} catch (NullPointerException e) {
			out.println("<p>" + hob + "</p>");
		}
		out.println("</div>");

		out.println("<div>");
		out.println("<p>Country: </p>");
		out.println("<p>" + origin + "</p>");
		out.println("</div>");

		out.println("<div>");
		out.println("<p>Languages Learned: </p>");
		try {
			for (String element : lang) {
				out.println("<p> " + element + "</p>");
			}
		} catch (NullPointerException e) {
			out.println("<p> " + lang + "</p>");
		}

		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
