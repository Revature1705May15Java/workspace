package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.RequestState;
import com.ers.service.Service;
import com.ers.util.RequestStatePool;

public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		String note = request.getParameter("note");
		
		HttpSession session = request.getSession();
		Employee manager = (Employee) session.getAttribute("user");
		
		Service service = new Service();
		Request r = service.getRequest(id);
		r.setNote(note);
		r.setManager(manager);
		
		if(action.equals("approve")) {
			r.setState(RequestStatePool.getState(RequestState.APPROVED));
		}
		else {
			r.setState(RequestStatePool.getState(RequestState.DENIED));
		}
		
		service.updateRequest(r);
		
		request.getRequestDispatcher("site.ftl").forward(request, response);
	}

}
