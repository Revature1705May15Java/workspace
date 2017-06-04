package com.bank.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service=new Service();
	private static User u = new User();
       
    public HomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("in home servlet get");
    	
    	HttpSession session = request.getSession(true);
    	u=(User) session.getAttribute("user");
    	
    	request.setAttribute("firstname", u.getFn());
    	request.setAttribute("lastname", u.getLn());
    	ArrayList<Integer> accounts=service.findAccounts(u.getId());
    	request.setAttribute("Account", accounts);
    	request.getRequestDispatcher("home.ftl").forward(request, response);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
