package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class RegisterEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register.ftl").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isManager = (request.getParameter("manager").equals("yes")) ? true : false;
		
		Service service = new Service();
		
		if(service.isEmailUnique(email)) {
			Employee employee = new Employee(firstName, lastName, email, password, isManager);
			service.addEmployee(employee);
			
			request.getRequestDispatcher("/manager.ftl").forward(request, response);
		}
		else {
			// TODO: Display some type of error message
		}
	}

}
