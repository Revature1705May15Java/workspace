package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;


public class EmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    HttpSession s = request.getSession();
	    if(s.getAttribute("employee") != null) {
	    	Employee emp = (Employee)s.getAttribute("employee");
	    	System.out.println(emp.getFirstName()+" "+emp.getLastName());
	    	request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
	    }
	    else {
	    	response.sendRedirect("login");
	    }
	    
	}
}

