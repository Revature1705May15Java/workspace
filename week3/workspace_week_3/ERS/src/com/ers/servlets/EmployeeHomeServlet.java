package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojo.User;
import com.ers.service.Service;

@WebServlet("/HomeServlet")
public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static User u = new User();
    static Service service = new Service();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Home..?");
		
		HttpSession session = request.getSession(true);
		u = (User) session.getAttribute("user");
		u = service.getUserInfo(u.getUsername()); // updating all request information about the user.
		
		if(u == null) response.sendRedirect("logout");
		else{	
			System.out.println("Requests: " + u.getRequests().size());
			request.setAttribute("fn", u.getFn());
			request.setAttribute("ln", u.getLn());
			request.setAttribute("Requests", u.getRequests());
			request.setAttribute("user", u);
			request.getRequestDispatcher("/Home.ftl").forward(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}