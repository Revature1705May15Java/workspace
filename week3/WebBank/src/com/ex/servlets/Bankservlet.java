package com.ex.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

@WebServlet("/Bankservlet")
public class Bankservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static boolean runonce=true;
	private ArrayList<User> bankUsers=new ArrayList<User>();
	
	DAO dao = new DaoImpl();
	
    public Bankservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(runonce){
		bankUsers.add(dao.getUser(100));
		bankUsers.add(dao.getUser(115));
		bankUsers.add(dao.getUser(200));
		runonce=false;
		}
		request.setAttribute("Users", bankUsers);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("fn");
		String ln =request.getParameter("ln");
		
		doGet(request, response);
	}

}
