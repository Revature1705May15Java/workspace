package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		if(emp!=null&&emp.getIsmanager()==1){
			if(session.getAttribute("showing")==null){
				session.setAttribute("showing", "none");
			}
			req.getRequestDispatcher("home.ftl").forward(req, resp);
		}else if(emp!=null&&emp.getIsmanager()==0){
			req.getRequestDispatcher("home2").forward(req, resp);
		}else{
			resp.sendRedirect("logout");
		}
	}

}