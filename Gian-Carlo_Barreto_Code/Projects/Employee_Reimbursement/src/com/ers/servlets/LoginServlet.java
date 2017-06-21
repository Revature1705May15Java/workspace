package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int NOTFOUND = -1;
	private static final int WPASS = 0;
	private static final int FOUND = 1;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the username and password from the login form
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		Employee employee = new Employee();
		Service service = new Service();
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request, if create is true.
		HttpSession session = request.getSession(true);
		request.setAttribute("login", "-");
		
		try {
			int status = service.confirmLogin(email, pass);
			if (status == FOUND) {
				System.out.println("Success");
				employee = service.getEmployee(email, pass);
				session.setAttribute("employee", employee);
				response.sendRedirect("empHome");
			}
			else if (status == WPASS) {
				System.out.println("ERROR");
				request.setAttribute("login", "wpass");
				request.getRequestDispatcher("index.ftl").forward(request, response);
			}
			else if (status == NOTFOUND) {
				System.out.println("ERROR");
				request.setAttribute("login", "not found");
				request.getRequestDispatcher("index.ftl").forward(request, response);
			}
		}
		catch (NullPointerException npe) {
			PrintWriter out = response.getWriter();
			out.println("Exception");
		}
	}

}
