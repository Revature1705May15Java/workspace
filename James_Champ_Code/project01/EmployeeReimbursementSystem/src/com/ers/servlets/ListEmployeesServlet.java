package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class ListEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service();
		ArrayList<Employee> employees = service.getAllEmployees();

		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/employeeList.ftl").forward(request, response);
	}

}
