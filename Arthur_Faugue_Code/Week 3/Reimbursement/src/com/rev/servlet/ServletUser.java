package com.rev.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.User;
import com.rev.service.Service;

public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Service serv = new Service();

    public ServletUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		
		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		String em = u.getEm();
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		request.setAttribute("email", em);
		
		s.setAttribute("user", u);
		if(u.getIsBoss()==1){
			request.getRequestDispatcher("bossUser.ftl").forward(request, response);
		}else{
			request.getRequestDispatcher("userinfo.ftl").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		String email = request.getParameter("email");
		String passw = request.getParameter("password");
		serv.updateUser(u, email, passw);
		
		u = serv.getUser(u);//gets the new user info
		
		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		String em = u.getEm();
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		request.setAttribute("email", em);
		
		s.setAttribute("user", u);
		if(u.getIsBoss()==1){
			request.getRequestDispatcher("bossUser.ftl").forward(request, response);
		}else{
			request.getRequestDispatcher("userinfo.ftl").forward(request, response);
		}
		
	}

}
