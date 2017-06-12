package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SubmitRequestServlet
 */
@WebServlet("/SubmitRequestServlet")
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	Service service = new Service();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the information submitted in the form
		double amount = Double.parseDouble(request.getParameter("amount"));
		String purpose = request.getParameter("purpose");
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request, if create is true.
		HttpSession session = request.getSession();
		request.setAttribute("created", "-");
		
		try {
			employee = (Employee) session.getAttribute("employee");
			Request req = service.createRequest(employee.getEmployeeId(), amount, purpose);
			if (req != null) {
				response.sendRedirect("empHome");
			}
			else {
				System.out.println("ERROR");
				request.setAttribute("created", "fail");
				request.getRequestDispatcher("submitRequest.ftl").forward(request, response);
			}
		}
		catch (NullPointerException npe) {
			PrintWriter out = response.getWriter();
			out.println("Exception");
		}
	}
}
