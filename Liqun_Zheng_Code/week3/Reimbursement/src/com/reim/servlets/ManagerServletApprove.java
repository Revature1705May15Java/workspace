package com.reim.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.service.Service;

public class ManagerServletApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		Employee emp = new Employee();
//		HttpSession s = request.getSession(true);
//		
//		emp = (Employee) s.getAttribute("Employee");
//		reqs = emp.getEmployee_request();
//		String fn = emp.getFn();
//		String ln = emp.getLn();
//		String uname = emp.getUname();
////		System.out.println(fn);
////		System.out.println(ln);
//		request.setAttribute("firstname", fn);
//		request.setAttribute("lastname", ln);
//		request.setAttribute("uname", uname);
//		request.setAttribute("requests", reqs);
////		System.out.println(request.getAttribute("firstname"));
////		System.out.println(request.getAttribute("lastname"));	
//		request.getRequestDispatcher("/employeeHome.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee emp = new Employee();
		Request req = new Request();

		int id = Integer.parseInt(request.getParameter("approveId"));
		String note = request.getParameter("noteApprove");
		System.out.println(id);
		System.out.println(note);
		
		HttpSession s = request.getSession(true);
		
		emp = (Employee) s.getAttribute("Manager");
		System.out.println(emp.toString());
		Service service = new Service();
		
 		req = service.approveReq(emp, id, note);
 		System.out.println(req.toString());
	
		Employee temp = service.Signin(emp.getUname(), emp.getPw());	
	
		s.setAttribute("Manager", temp);
		response.sendRedirect("managerHome");
	}
}
