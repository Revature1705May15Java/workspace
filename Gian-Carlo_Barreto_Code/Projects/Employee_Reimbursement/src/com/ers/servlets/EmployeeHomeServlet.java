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
 * Servlet implementation class EmployeeHomeServlet
 */
@WebServlet("/EmployeeHomeServlet")
public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
       
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
		ArrayList<Request> requests = service.getEmployeeRequests(employee.getEmployeeId());
		ArrayList<Employee> employees = service.getAllEmployees();
		
		// Sets the firstname and lastname attributes of the request
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		
		
		// Go to the employee home page if employee is not a manager, 
		// else go to the manager home page
		if (employee.isManager()) {
			ArrayList<Request> pending = service.getAllPendingRequest();
			ArrayList<Request> resolved = service.getAllResolvedRequest();
			
			for (Request pend : pending) {
				for (Employee emp : employees) {
					if (pend.getEmployeeId() == emp.getEmployeeId()) {
						pend.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
					}
				}
			}
			
			for (Request res : resolved) {
				for (Employee emp : employees) {
					if (res.getEmployeeId() == emp.getEmployeeId()) {
						res.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
					}
					if (res.getManagerId() == emp.getEmployeeId()) {
						res.setManagerName(emp.getFirstName() + " " + emp.getLastName());
					}
				}
			}
			
			request.setAttribute("pending", pending);
			request.setAttribute("resolved", resolved);
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("/manHome.ftl").forward(request, response);
		}
		else {
			for (Request req : requests) {
				for (Employee emp : employees) {
					if (req.getManagerId() == emp.getEmployeeId()) {
						req.setManagerName(emp.getFirstName() + " " + emp.getLastName());
					}
				}
			}
			request.setAttribute("requests", requests);
			request.getRequestDispatcher("/empHome.ftl").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
