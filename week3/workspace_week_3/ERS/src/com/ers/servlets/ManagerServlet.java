package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.Service;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname = request.getParameter("username");
		String pw = request.getParameter("password");
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		String rankString = request.getParameter("rank");
		int rank;
		if(rankString.equals("manager")) rank = 1;
		else rank = 0;
		
		if(rank != 1) rank = 0;
		int test = service.addUser(uname, pw, fn, ln, rank);
		if(test == 1) {
			request.setAttribute("createuser", "success");
			request.getRequestDispatcher("Home2.ftl").forward(request, response);
		} else if(test == 0) {
			request.setAttribute("createuser", "fail");
			request.getRequestDispatcher("Home2.ftl").forward(request, response);
		}
		
	}
}
