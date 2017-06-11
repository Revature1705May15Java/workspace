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
import com.ers.service.Service;


@WebServlet("/ManHomeServlet")
public class ManHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	Service service = new Service();
	
	 public ManHomeServlet() {
	        super();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
		
		e = (Employee)session.getAttribute("employee");
		request.setAttribute("fn", e.getFirstName());
		request.setAttribute("ln", e.getLastName());
		request.setAttribute("email", e.getEmail());
		ArrayList<Employee> employees = service.getAllEmployees();
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("/manhome.ftl").forward(request, response);
		}
		catch(NullPointerException npe){
			//request.getRequestDispatcher("index.ftl").forward(request, response);
			response.sendRedirect("index.ftl");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
