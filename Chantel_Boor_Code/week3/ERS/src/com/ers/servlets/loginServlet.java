package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email = request.getParameter("username");
		String pw = request.getParameter("password");
		
		request.setAttribute("login", "-");
		
		Service s = new Service();
		Employee e = new Employee();
		
		
		try
		{
			
			e = s.login(email,pw);
			HttpSession sess = request.getSession(true);
			
			if(e.getEmployeeId() != 0)
			{
				
				if(e.getIsManager() == 1)
				{
					sess.setAttribute("user", e);
					request.getRequestDispatcher("mHome.ftl").forward(request, response);
				}
				else
				{
					sess.setAttribute("user", e);
					request.getRequestDispatcher("displayRequests").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("login","fail");
				request.getRequestDispatcher("index.ftl").forward(request, response);
				
			}
		}catch (NullPointerException n)
		{
			n.printStackTrace();
		}
		
		
	}

}
