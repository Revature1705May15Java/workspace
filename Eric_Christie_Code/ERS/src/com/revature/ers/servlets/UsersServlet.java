package com.revature.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.User;
import com.revature.ers.service.ExpenseReimbursementService;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * This servlet should only be accessible to managers. 
	 * If the current user is an employee, requests to this servlet should return an error status code.
	 * If the current user is a manager:
	 * - POST registers an account for a new user
	 * 
	 * -- having GET retrieve the account information of all users may be worth considering
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ExpenseReimbursementService service = new ExpenseReimbursementService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      if (u.isManager()) {
        /*
         * (maybe) retrieve the account settings/information for all employees, all managers, or all usersSSSS
         */
      } else {
        /*
         * respond with an error status code
         */
        
      }
    } else {
      /*
       * if there is no current user stored in the session, redirect to login page
       */
      response.sendRedirect("login");
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ExpenseReimbursementService service = new ExpenseReimbursementService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      if (u.isManager()) {
        /*
         * retrieve information for all reimbursement requests (and possibly all Users too)
         */
      } else {
        /*
         * respond with an error status code
         */
        
      }
    } else {
      /*
       * if there is no current user stored in the session, redirect to login page
       */
      response.sendRedirect("login");
    }
	}

}
