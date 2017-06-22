package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

/**
 * Servlet implementation class addEmployee
 */
@WebServlet("/addEmployee")
public class addEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Employee e = new Employee();
	static Service service = new Service();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession sess = request.getSession(true);
		Service s = new Service ();
		e = (Employee)sess.getAttribute("user");
		
		//get user input
		String fn = request.getParameter("fn");
		String ln = request.getParameter("ln");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String isM = request.getParameter("isManager");
		
		//make request and send back to e home
		boolean added = s.addEmployee(fn, ln, email, pass, isM);
		sess.setAttribute("user", e);
		request.setAttribute("add", "-");
		request.setAttribute("name", e.getfName() + " " + e.getlName());
		
		if(!added)
		{
			request.setAttribute("add", "fail");
		}
		
		request.getRequestDispatcher("mHomeDataTable.ftl").forward(request, response);

	}

}
