package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Service s = new Service();
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		User u = new User();
		
		request.setAttribute("login", "-");
		
		try
		{
			u = s.loginUser(user, pass);
			HttpSession sess = request.getSession(true);
			
			if(u.getId() != 0)
			{
				sess.setAttribute("user", u);
				response.sendRedirect("home");
			}
			else
			{
				request.setAttribute("login","fail");
				request.getRequestDispatcher("login.ftl").forward(request, response);
				
			}
		}catch (NullPointerException n)
		{
			n.printStackTrace();
		}
	}

}
