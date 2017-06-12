package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

/**
 * Servlet implementation class ReimbursementView
 */
@WebServlet("/ReimbursementView")
public class ReimbursementView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the current valid session associated with this request, 
				// if create is false or, if necessary, creates a new session for the request
		HttpSession session = request.getSession();
		
		// Gets the employee that is currently logged in
		employee = (Employee) session.getAttribute("employee");
		
		ArrayList<Request> requests = service.getEmployeeRequests(employee.getEmployeeId());
		request.setAttribute("requests", requests);
		
		request.getRequestDispatcher("/reimbursementsView.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
