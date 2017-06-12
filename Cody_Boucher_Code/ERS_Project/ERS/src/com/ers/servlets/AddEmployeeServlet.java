package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class AddEmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Service service = new Service();
		HttpSession s = request.getSession(true);
		//Employee emp = (Employee) s.getAttribute("emp");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		boolean isManager = Boolean.parseBoolean(request.getParameter("isManager"));
		Employee newEmp = service.addEmploye(username, password, firstName, lastName, isManager);
		if(newEmp != null) {
			System.out.println("New Employee Added");
		}
		request.getRequestDispatcher("managerHome.ftl").forward(request, response);
	}

}
