package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.service.Service;

public class ViewAllPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service();
		ArrayList<Request> pending = service.getAllRequests(new RequestState(RequestState.PENDING));

		request.setAttribute("requests", pending);
		request.getRequestDispatcher("viewRequests.ftl").forward(request, response);
	}

}
