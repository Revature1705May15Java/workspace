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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Service svc = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		Employee emp = new Employee();
		Service service = new Service();
		HttpSession s = request.getSession(true);
		request.setAttribute("login", "-");
		
		
//		PrintWriter out = response.getWriter();
//		String myContextParam = request.getSession().getServletContext().getInitParameter("myParam");
//		String name = request.getParameter("username");
//		String password = request.getParameter("password");
//		out.println(myContextParam + " " + name + " " + password);
		
		try{
			emp = service.login(username, pass);
			if(emp != null) {
				System.out.println("yes");
					s.setAttribute("username", emp);
					response.sendRedirect("employeeHome.ftl");
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

}
