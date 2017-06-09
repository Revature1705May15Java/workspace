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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String myContextParam =
		// request.getSession().getServletContext().getInitParameter("myParam");
		String email = request.getParameter("email");
		String pw = request.getParameter("password");
		HttpSession session = request.getSession(true);
		request.setAttribute("login", "-");
		Employee e = new Employee();

		Service service = new Service();
		try {
			boolean isEmployee = true;
			if (service.checkEmail(email) == false) {
				isEmployee = false;
			} else {
				if (service.checkPassword(email, pw) == false) {
					isEmployee = false;
				} else {
					e = service.getEmployee(email);
					
					
				}
			}
			// If user is employee, will check to see if employee is a manager.
			if (isEmployee) {
				if(e.getIsManager()==1){
				session.setAttribute("employee", e);
				response.sendRedirect("manhome");
				}
				// RequestDispatcher rd =
				// request.getRequestDispatcher("Success.html");
				// rd.forward(request, response);
			} else {

				request.setAttribute("login", "fail");
				request.getRequestDispatcher("index.ftl").forward(request, response);
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	}
}
// out.println(myContextParam + " " + name + " " + pw);