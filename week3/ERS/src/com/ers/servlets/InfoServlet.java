package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newfn="";
		String newln="";
		String newemail="";
		String newpw="";
			newfn = req.getParameter("newfn");
			newln = req.getParameter("newln");
			newemail = req.getParameter("newemail");
			newpw=req.getParameter("newpw");

		
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		if(newfn!=null){
			if(newfn==""){
				newfn=emp.getFirstname();
			}
			if(newln==""){
				newln=emp.getLastname();
			}
			if(newemail==""){
				newemail=emp.getEmail();
			}
			if(newpw==""){
				newpw=emp.getPassword();
			}
			int empid=emp.getId();
			Service.updateEmployee(newemail, newpw, newfn, newln, empid);
			Employee newemp=Service.loginUser(newemail, newpw);
			session.setAttribute("employee", newemp);
		}
			req.getRequestDispatcher("home").forward(req, resp);
		
	}
}