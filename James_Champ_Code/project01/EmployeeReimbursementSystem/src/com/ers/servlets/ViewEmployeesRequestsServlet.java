package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Request;
import com.ers.service.Service;
import com.ers.servlets.states.SessionState;


public class ViewEmployeesRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service();
		
		int requestId = Integer.parseInt(request.getParameter("reqId"));
		Request r = service.getRequest(requestId);
		
		ArrayList<Request> requests = service.getRequestsByEmployee(r.getRequester());
		
		HttpSession session = request.getSession();
		session.setAttribute("requests", requests);
		session.setAttribute("state", SessionState.VIEW_EMPLOYEES_REQUESTS);
		request.getRequestDispatcher("site.ftl").forward(request, response);
	}

}
