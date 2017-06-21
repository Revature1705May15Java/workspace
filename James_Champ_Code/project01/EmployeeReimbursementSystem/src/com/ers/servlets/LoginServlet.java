package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.exceptions.InvalidPasswordException;
import com.ers.exceptions.NoSuchEmployeeException;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.service.Service;
import com.ers.servlets.states.SessionState;
import com.ers.util.RequestStatePool;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();

		Service service = new Service();
		
		try {
			Employee employee = service.login(email, password);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", employee);
			session.setAttribute("state", SessionState.VIEW_PENDING);
			
			ArrayList<Request> pendingRequests;
			
			if(employee.getIsManager()) {
				pendingRequests = service.getAllRequestsByState(RequestStatePool.getState(RequestState.PENDING));
			}
			else {
				pendingRequests = service.getRequestsByState(employee, false);
			}
			
			session.setAttribute("pendingRequests", pendingRequests);
			
			request.getRequestDispatcher("site.ftl").forward(request, response);
		} 
		catch(NoSuchEmployeeException | InvalidPasswordException e) {
			request.setAttribute("error", "true");
			request.getRequestDispatcher("site.ftl").forward(request, response);
		}
	}
}
