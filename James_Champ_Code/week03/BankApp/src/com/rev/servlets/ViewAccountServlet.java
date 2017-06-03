package com.rev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.service.Service;


public class ViewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("account");
		Service service = new Service();
		Account account = service.getAccount(Integer.parseInt(accountId));
		String accountHolders = "";
		
		for(User u : account.getAccountHolders()) {
			accountHolders += u.getFirstName() + " " + u.getLastName() + ", ";
		}
		
		accountHolders = accountHolders.substring(0, accountHolders.length() - 2);
		
		request.setAttribute("accountHolders", accountHolders);
		request.setAttribute("account", account);
		request.getRequestDispatcher("/details.ftl").forward(request, response);
	}
}
