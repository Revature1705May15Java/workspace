package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class UpdateEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");
		
		String fname = (String) request.getParameter("fname");
		String lname = (String) request.getParameter("lname");
		String email = (String) request.getParameter("email");
		String pwd = (String) request.getParameter("pwd");
		
		Service service = new Service();		
		
		if(email != null && email.length() > 0) {
			if(service.isEmailUnique(email)) {
				employee.setEmail(email);
			}
			else {
				// TODO: Error message
			}
		}
		
		if(fname != null && fname.length() > 0) {
			employee.setFirstName(fname);
		}
		if(lname != null && lname.length() > 0) {
			employee.setLastName(lname);
		}
		if(pwd != null && pwd.length() > 0) {
			employee.setPassword(pwd);
		}
		
		employee = service.updateEmployee(employee);
		session.setAttribute("user", employee);
		
		request.getRequestDispatcher("site.ftl").forward(request, response);
		// TODO: Print success message
	}

}
