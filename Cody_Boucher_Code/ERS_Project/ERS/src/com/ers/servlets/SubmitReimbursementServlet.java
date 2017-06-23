package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.service.Service;

public class SubmitReimbursementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Service service = new Service();
		HttpSession s = request.getSession(true);
		Employee emp = (Employee) s.getAttribute("employee");
		System.out.println(emp);
		double amount = Double.parseDouble(request.getParameter("amount"));
		System.out.println(amount);
		String purpose = request.getParameter("purpose");
		System.out.println(purpose);
		Reimbursement rem = service.requestReimbursement(emp, amount, purpose);
		if(rem != null) {
			System.out.println("Request Submitted");
		}
		//request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
		response.sendRedirect("employeeHome");
	}
}
