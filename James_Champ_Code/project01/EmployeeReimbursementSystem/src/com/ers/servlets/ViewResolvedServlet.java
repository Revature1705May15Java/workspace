package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.service.Service;
import com.ers.servlets.states.SessionState;
import com.ers.util.RequestStatePool;

public class ViewResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");
		
		Service service = new Service();
		ArrayList<Request> requests;
		
		if(employee.getIsManager()) {
			requests = service.getAllRequestsByState(RequestStatePool.getState(RequestState.APPROVED));
			requests.addAll(service.getAllRequestsByState(RequestStatePool.getState(RequestState.DENIED)));
		}
		else {
			requests = service.getRequestsByState(employee, true);
		}
		
		session.setAttribute("requests", requests);
		session.setAttribute("state", SessionState.VIEW_RESOLVED);
		request.getRequestDispatcher("site.ftl").forward(request, response);
	}

}
