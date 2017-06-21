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
import com.ers.service.Service;

/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/UpdateInfoServlet")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Employee employee;
    Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the information submitted in the form.
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request, if create is true.
		HttpSession session = request.getSession();
		request.setAttribute("updated", "-");
		
		try {
			employee = (Employee) session.getAttribute("employee");
			if (email.equals(employee.getEmail())) {
				boolean update = service.updateEmployee(employee.getEmployeeId(), firstName, lastName, email);
				if (update) {
					employee.setFirstName(firstName);
					employee.setLastName(lastName);
					employee.setEmail(email);
					session.setAttribute("employee", employee);
					response.sendRedirect("empHome");
				}
				else {
					System.out.println("ERROR");
					request.setAttribute("updated", "fail");
					request.getRequestDispatcher("updateInfo.ftl").forward(request, response);
				}
			}
			else {
				if (service.isEmailAvailable(email)) {
					boolean update = service.updateEmployee(employee.getEmployeeId(), firstName, lastName, email);
					if (update) {
						response.sendRedirect("empHome");
					}
					else {
						System.out.println("ERROR");
						request.setAttribute("updated", "fail");
						request.getRequestDispatcher("updateInfo.ftl").forward(request, response);
					}
				}
				else {
					System.out.println("Email not available");
					request.setAttribute("updated", "fail");
					request.getRequestDispatcher("updateInfo.ftl").forward(request, response);
				}
			}
		} 
		catch (NullPointerException npe) {
			PrintWriter out = response.getWriter();
			out.println("Exception");
		}
	}

}
