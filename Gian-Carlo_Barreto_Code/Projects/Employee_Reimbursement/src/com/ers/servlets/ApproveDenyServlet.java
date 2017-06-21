package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

/**
 * Servlet implementation class ApproveDenyServlet
 */
@WebServlet("/ApproveDenyServlet")
public class ApproveDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	Service service = new Service();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the manager's note and decision
		String managerNote = request.getParameter("note");
		String decision = request.getParameter("choice");
		int requestId = Integer.parseInt(request.getParameter("reqid"));
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request, if create is true.
		HttpSession session = request.getSession();
		
		try {
			employee = (Employee) session.getAttribute("employee");
			int managerId = employee.getEmployeeId();
			int state = 0;
			
			if (decision.equals("approve"))
				state = 2;
			else
				state = 3;
			
			if (service.closeRequest(requestId, state, managerId, managerNote))
				response.sendRedirect("empHome");
			else
				System.out.println("ERROR");
		}
		catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		
	}

}
