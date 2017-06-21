package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.ers.servlets.states.SessionState;

public class ListEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service();
		ArrayList<Employee> employees = service.getAllEmployees();
		
		HttpSession session = request.getSession();
		session.setAttribute("employees", employees);
		session.setAttribute("state", SessionState.VIEW_EMPLOYEES);

		request.getRequestDispatcher("site.ftl").forward(request, response);
	}

}
