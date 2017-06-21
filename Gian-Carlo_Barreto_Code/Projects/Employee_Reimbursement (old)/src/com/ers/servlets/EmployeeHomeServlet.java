package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;

/**
 * Servlet implementation class EmployeeHomeServlet
 */
@WebServlet("/EmployeeHomeServlet")
public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeHomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request.
		HttpSession session = request.getSession();
		
		employee = (Employee) session.getAttribute("employee");
		
		// Gets the employees first name and last name
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		
		// Sets the firstname and lastname attributes of the request
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		
		// Go to the employee home page if employee is not a manager, 
		// else go to the manager home page
		if (employee.isManager())
			request.getRequestDispatcher("/manHome.ftl").forward(request, response);
		else
			request.getRequestDispatcher("/empHome.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
