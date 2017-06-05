package com.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static User u = new User();
    static Service service = new Service();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Home..");
		
		HttpSession session = request.getSession(true);
		
		u = (User) session.getAttribute("user");
		
		if(u != null){
		request.setAttribute("fn", u.getFn());
		request.setAttribute("ln", u.getLn());
		request.setAttribute("Account", u.getAccounts());
		request.getRequestDispatcher("/home.ftl").forward(request, response);
		}
		else {
			System.out.println("In home else...");
			request.getRequestDispatcher("/index.html").forward(request, response);
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
