package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ers.service.*;
import com.ers.pojos.*;

/**
 * Servlet implementation class addRequest
 */
@WebServlet("/addRequest")
public class addRequest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Employee e = new Employee();
	static Service service = new Service();
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//get session info 
		HttpSession sess = request.getSession(true);
		Service s = new Service ();
		e = (Employee)sess.getAttribute("user");
		
		//get user input
		double amount = Double.parseDouble(request.getParameter("amount")); 
		String reason = request.getParameter("purp");
		
		if(amount > 0)
		{
			s.addRequest(amount, reason, e);
			sess.setAttribute("user", e);
			request.getRequestDispatcher("displayRequests").forward(request, response);
		}
		else
		{
			sess.setAttribute("user", e);
			request.getRequestDispatcher("displayRequests").forward(request, response);
		}
	}

}
