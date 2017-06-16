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

public class ServletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Service serv = new Service();
	
    public ServletEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		ArrayList<User> usrArr = new ArrayList<User>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		
//		System.out.println("State id = " + id);
//		
//		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		
		
		accs = serv.getAllRequests();
		usrArr = serv.getAllEmployees();
		
		request.setAttribute("users", usrArr);
		request.setAttribute("requests", accs);
		request.getRequestDispatcher("bossEmployees.ftl").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
	}

}
