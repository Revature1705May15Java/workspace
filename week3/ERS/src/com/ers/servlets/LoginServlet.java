package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();
		String myContextParam=req.getSession().getServletContext().getInitParameter("myParam");
		String name = req.getParameter("username");
		String pw=req.getParameter("password");
		Employee emp = Service.loginUser(name, pw);
		if(emp.getIsmanager()==1){
			req.getRequestDispatcher("home.ftl").forward(req, resp);
			resp.sendRedirect("Home");
		}else if(emp.getIsmanager()==0){
			req.getRequestDispatcher("home2.ftl").forward(req, resp);
			resp.sendRedirect("Home");
		}
		
		out.println(myContextParam+" "+name+" "+pw);
		doGet(req, resp);
	}

}
