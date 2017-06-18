package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.service.Service;

public class UpdateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Service service = new Service();
		Reimbursement updatedReim = new Reimbursement();
		HttpSession s = request.getSession(true);
		Employee emp = (Employee) s.getAttribute("employee");
		System.out.println(emp);
		int id = Integer.parseInt(request.getParameter("requestID"));
		System.out.println(id);
		String note = request.getParameter("notes");
		System.out.println(note);
	
		int state = Integer.parseInt(request.getParameter("stateId"));
		System.out.println(state);

		updatedReim = service.updateReimbursement(id, emp, note, state);
		System.out.println(updatedReim);
		
		request.getRequestDispatcher("managerHome.ftl").forward(request, response);
	}
}
