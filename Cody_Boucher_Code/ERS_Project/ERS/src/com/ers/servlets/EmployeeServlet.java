package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.service.Service;


public class EmployeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    HttpSession s = request.getSession();
	    if(s.getAttribute("employee") != null) {
	    	Employee emp = (Employee)s.getAttribute("employee");
	    	Service service = new Service();
	    	ArrayList<Reimbursement> empReimbursements = new ArrayList<Reimbursement>();
	    	ArrayList<Reimbursement> penReimbursements = new ArrayList<Reimbursement>();
	    	ArrayList<Reimbursement> arcReimbursements = new ArrayList<Reimbursement>();
			empReimbursements = service.getEmpReimbursements(emp);
			for(Reimbursement r : empReimbursements) {
				if(r.getStateId() == 1) {
					penReimbursements.add(r);
				}
				else {
					arcReimbursements.add(r);
				}
			}
			System.out.println(empReimbursements.toString());
	    	System.out.println(emp.getFirstName()+" "+emp.getLastName());
	    	s.setAttribute("penReimbursements", penReimbursements);
	    	s.setAttribute("arcReimbursements", arcReimbursements);
	    	System.out.println(emp.getFirstName()+" "+emp.getLastName());
	    	request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
	    }
	    else {
	    	response.sendRedirect("login");
	    }
	    
	}
}

