package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Requests;
import com.ers.service.Service;

/**
 * Servlet implementation class displayRequests
 */
@WebServlet("/displayRequests")
public class displayRequests extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public displayRequests() 
    {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession sess = request.getSession(true);
		Service s = new Service ();
		Employee e = (Employee)sess.getAttribute("user");
		
		ArrayList <Requests> rlist = s.getRequests(e);
		
		request.setAttribute("name", e.getfName() + " " + e.getlName());
		request.setAttribute("requests",rlist);
		request.setAttribute("display", "no");
		
		sess.setAttribute("user", e);
		
		if(rlist.get(0).getRequestId() != 0)
		{
			request.setAttribute("display", "yes");
		}
		
		request.getRequestDispatcher("eHome.ftl").forward(request, response);
	}

}
