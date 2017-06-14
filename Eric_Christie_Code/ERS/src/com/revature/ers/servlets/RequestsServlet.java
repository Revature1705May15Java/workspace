package com.revature.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;

/**
 * Servlet implementation class ReimbursementRequestServlet
 */
public class RequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * The behavior of the doGet and doPost methods should depend on whether the request sender is an employee or a manager.
	 * For employees:
	 * - GET retrieves all the reimbursement requests submitted by the current user
	 * - POST creates a new reimbursement request with the current user as the requester
	 * For managers:
	 * - GET retrieves all the reimbursement requests submitted by every employee and the information for every employee 
	 *   (should be organized into a reasonable format)
	 * - POST updates a reimbursement request, changing its state to either approved or denied
	 */
	
	/*
	 * formatting the data as JSON:
	 * - the reimbursement requests data could be serialized as an array of JSON Request objects with the 
	 *   complete information of the requester and resolver (excluding the accounts arrays) included as properties of each object
	 * - the data could be transmitted as an array of JSON User/employee objects that each have a property that is an array of the
	 *   requests made by that employee, and the resolver could be a property of those requests
	 * - the complete lists of Users and the complete list of Requests could be serialized independently as just the JSON form of
	 *   the pojos. this would require the client to organize the information before displaying it, but would also allow the Users
	 *   and Requests to be sent in separate responses
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
	  HttpSession session = request.getSession();
	  User u = (User) session.getAttribute("user");
	  if (u != null) {
	    if (u.isManager()) {
	      /*
	       * retrieve information for all reimbursement requests (and possibly all Users too)
	       * (maybe paginate the data and just retrieve up to a specific number of reimbursement requests)
	       */
	    } else {
	      /*
	       * retrieve information for all reimbursement requests created by the current employee
	       * (possibly consider paginating the data)
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
	  ERService service = new ERService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      if (u.isManager()) {
        /*
         * parse request body and (if it contains all the necessary fields) use its contents to update/resolve 
         * a Request as the current manager then respond with the JSON representation of the updated Request object,
         * otherwise respond with error code
         */
      } else {
        /*
         * parse request body and (if it contains the necessary fields) use its contents to add/create
         * a Request as the current employee then respond with the JSON representation of the created Request object,
         * otherwise respond with error code
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
