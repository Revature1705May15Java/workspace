package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.exceptions.InvalidPasswordException;
import com.ers.exceptions.NoSuchEmployeeException;
import com.ers.pojos.Employee;
import com.ers.service.Service;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();

		Service service = new Service();
		
		// TODO: Display message on page if exception is caught
		try {
			Employee employee = service.login(email, password);
			
			if(employee.isManager()) {
				request.getRequestDispatcher("managerPlaceholder.html").forward(request, response);		
			}
			else {
				request.getRequestDispatcher("employeePlaceholder.html").forward(request, response);
			}
		} 
		catch(NoSuchEmployeeException e) {
			e.printStackTrace();
		}
		catch(InvalidPasswordException e) {
			e.printStackTrace();
		}
	}

}
