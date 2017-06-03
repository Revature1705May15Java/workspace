package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.User;
import com.rev.service.Service;

/**
 * Servlet implementation class NewMemberServlet
 */
@WebServlet("/NewMemberServlet")
public class NewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Service service = new Service();
		User user = service.addUser(firstName, lastName, password, email);
		
		if(user == null) {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		else {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/member.ftl").forward(request, response);
		}
	}

}
