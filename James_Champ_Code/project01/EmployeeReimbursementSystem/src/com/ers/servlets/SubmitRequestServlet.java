package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount = Double.parseDouble(request.getParameter("amount"));
		String purpose = request.getParameter("purpose");
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");
		
		Request submission = new Request(amount, purpose, employee);
		Service service = new Service();
		service.submitRequest(submission);
		
		// TODO: Display results
		// TODO: Accept decimal values for reimbursement amount.
		request.getRequestDispatcher("employee.ftl").forward(request, response);
	}

}
