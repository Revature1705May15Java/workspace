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

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = session.getAttribute("uname").toString();
		User temp = service.getUserInfo(username);
		
		int test = 0;
		try{
			int amount = Integer.parseInt(request.getParameter("amount"));
			String purpose = request.getParameter("purpose");
		
			test = service.addRequest(amount, purpose, temp.getId());
			if(test == 1) {
				request.setAttribute("createrequest", "success");
				request.getRequestDispatcher("Home.ftl").forward(request, response);
			} else if(test == 0) {
				request.setAttribute("createrequest", "fail");
				request.getRequestDispatcher("Home.ftl").forward(request, response);
			}
		}
		catch(NumberFormatException e){
			request.setAttribute("createrequest", "fail");
			request.getRequestDispatcher("Home.ftl").forward(request, response);
		}
	}

}
