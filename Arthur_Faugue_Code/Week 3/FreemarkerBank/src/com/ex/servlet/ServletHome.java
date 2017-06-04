package com.ex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojo.Account;
import com.bank.pojo.User;
import com.bank.service.Service;


//@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Service serv = new Service();
	
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.getRequestDispatcher("/login.ftl");
		User u = new User();
		ArrayList<Account> accs = new ArrayList<Account>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
//		int x = u.getId();
//		accs = serv.showAccounts(x);
		accs = u.getUserAccounts();
		
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("accounts", accs);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		
		if(fn.equals("Arthur")){
			request.getRequestDispatcher("boss.ftl").forward(request, response);
		}else{
			request.getRequestDispatcher("user.ftl").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		Account a = new Account();
		String chec = request.getParameter("bal");
		HttpSession s = request.getSession(true);
		ArrayList<Account> accs = new ArrayList<Account>();
		
		
		double bl = Double.parseDouble(chec);
		u = (User) s.getAttribute("user");
//		int x = u.getId();
		a = serv.getAccount(10001);
		serv.updateBalance(a, bl);
		System.out.println("Servlet: " + a.getBalance());
		accs = u.getUserAccounts();
//		accs = serv.showAccounts(x);
		int temp =1;
		for(Account i:accs){
			if(i.getId() == 10001){
				i = a;
			}
			System.out.println(temp+ " : " +i.getBalance());
			temp++;
		}
		
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("accounts", accs);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		response.reset();
		request.getRequestDispatcher("user.ftl").forward(request, response);
	}

}
