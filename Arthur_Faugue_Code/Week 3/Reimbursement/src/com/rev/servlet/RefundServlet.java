package com.rev.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.User;
import com.rev.service.Service;

/**
 * Servlet implementation class RefundServlet
 */
//@WebServlet("/RefundServlet")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Service serv = new Service();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		User u = new User();
		HttpSession s = request.getSession(true);
		u = serv.userLogin(username, password);
		try{
			
			if(!u.getFn().isEmpty()){//if empty then fail
				s.setAttribute("user", u);//stores name and object when you retrieve you cast back
				response.sendRedirect("home");//take response and send to an action to servlet(home is defined in web.x)
			}
		}catch(NullPointerException e){
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("loginf.ftl").forward(request, response);
//			response.sendRedirect("Error.html");
		}
	}

}