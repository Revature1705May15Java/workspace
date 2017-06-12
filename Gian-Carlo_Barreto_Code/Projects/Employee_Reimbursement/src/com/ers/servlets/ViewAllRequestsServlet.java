package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Request;
import com.ers.service.Service;

/**
 * Servlet implementation class ViewAllRequestsServlet
 */
@WebServlet("/ViewAllRequestsServlet")
public class ViewAllRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Request> requests = service.getAllRequests();
		request.setAttribute("requests", requests);
		
		request.getRequestDispatcher("/viewAllRequests.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
