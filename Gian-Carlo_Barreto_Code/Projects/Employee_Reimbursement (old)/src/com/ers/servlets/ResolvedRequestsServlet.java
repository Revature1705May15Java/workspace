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
 * Servlet implementation class ResolvedRequestsServlet
 */
@WebServlet("/ResolvedRequestsServlet")
public class ResolvedRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Request> requests = service.getAllResolvedRequest();
		request.setAttribute("requests", requests);
		
		request.getRequestDispatcher("/viewResolvedRequests.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
