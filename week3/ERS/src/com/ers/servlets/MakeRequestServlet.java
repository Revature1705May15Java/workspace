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
import com.ers.service.Service;

public class MakeRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		if(emp!=null&&emp.getIsmanager()==0){
			double amount=Double.parseDouble(req.getParameter("Amount"));
			String purpose =(String)req.getParameter("Purpose");
			Service.newRequest(amount, purpose, emp);
			ArrayList<Request> reqs=new ArrayList<Request>();
			reqs=Service.getRequests(emp);
			session.setAttribute("requests", reqs);
			session.setAttribute("modrequests", reqs);
			resp.sendRedirect("home2");
		}else{
			resp.sendRedirect("logout");
		}
	}

}
