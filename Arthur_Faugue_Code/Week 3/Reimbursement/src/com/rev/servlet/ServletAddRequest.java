package com.rev.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.Request;
import com.rev.pojo.User;
import com.rev.service.Service;


public class ServletAddRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Service serv = new Service(); 
    
    public ServletAddRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String purpose = request.getParameter("purpose");
		
		serv.makeRequest(u, amount, purpose);
		
		accs = serv.getUserRequests(u);
		
//		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("requests", accs);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		
		request.getRequestDispatcher("user.ftl").forward(request, response);
	}

}
