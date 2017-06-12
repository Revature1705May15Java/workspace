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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gets the username and password from the login form
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		Employee employee = new Employee();
		Service service = new Service();
		
		// Gets the current valid session associated with this request, 
		// if create is false or, if necessary, creates a new session for the request, if create is true.
		HttpSession session = request.getSession(true);
		request.setAttribute("login", "-");
		
		try {
			employee = service.confirmLogin(user, pass);
			if (employee != null) {
				System.out.println("Success");
				session.setAttribute("employee", employee);
				response.sendRedirect("empHome");
			}
			else {
				System.out.println("ERROR");
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("index.ftl").forward(request, response);
			}
		}
		catch (NullPointerException npe) {
			PrintWriter out = response.getWriter();
			out.println("Exception");
		}
	}

}
