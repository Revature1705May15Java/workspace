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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		Employee emp;
		Service service = new Service();
		HttpSession s = request.getSession(true);
		request.setAttribute("login", "-");
		
		if(username != null && pass != null && !username.equals("") && !pass.equals("")) {
			try{
//				request.setAttribute("login", "-");
				emp = service.login(username, pass);
				if(emp != null && emp.isManager() == false) {
					System.out.println("yes");
						s.setAttribute("employee", emp);
//						ArrayList<Reimbursement> empReimbursements = new ArrayList<Reimbursement>();
//						empReimbursements = service.getEmpReimbursements(emp);
//						System.out.println(empReimbursements.toString());
//				    	System.out.println(emp.getFirstName()+" "+emp.getLastName());
//				    	s.setAttribute("empReimbursements", empReimbursements);
						response.sendRedirect("employeeHome");
					}
				else if(emp != null && emp.isManager() == true) {
					System.out.println("yes, manager");
					s.setAttribute("employee", emp);
//					ArrayList<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
//					allReimbursements = service.getAllReimbursements();
//					s.setAttribute("allReimbursements", allReimbursements);
					response.sendRedirect("managerHome");
				}
				
				else{
					request.setAttribute("login", "fail");
					try {
						request.getRequestDispatcher("login.ftl").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
				
				}catch(NullPointerException npe){
					System.out.println("eeror");
					//response.sendRedirect("Error.html");	
			}
		}
		else {
			System.out.println("yup");
			request.getRequestDispatcher("login.ftl").forward(request, response);
		}	
	}	
}