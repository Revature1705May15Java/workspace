package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Service service = new Service();
		Employee updatedEmp = new Employee();
		HttpSession s = request.getSession(true);
		Employee emp = (Employee) s.getAttribute("employee");
		System.out.println(emp);
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		String firstName = request.getParameter("firstName");
		System.out.println(firstName);
		String lastName = request.getParameter("lastName");
		System.out.println(lastName);
		updatedEmp = service.updateEmployee(emp, username, password, firstName, lastName);
		if(updatedEmp != null) {
			System.out.println("Employee Updated");
			System.out.println(updatedEmp);
		}
		request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
	}
}
