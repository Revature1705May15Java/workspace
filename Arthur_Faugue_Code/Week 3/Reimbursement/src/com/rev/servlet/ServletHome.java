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

/**
 * Servlet implementation class ServletHome
 */
//@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Service serv = new Service();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		
		accs = u.getUserRequest();
		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("requests", accs);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		
		if(u.getIsBoss()==1){
			request.getRequestDispatcher("boss.ftl").forward(request, response);
		}else{
			request.getRequestDispatcher("user.ftl").forward(request, response);
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
