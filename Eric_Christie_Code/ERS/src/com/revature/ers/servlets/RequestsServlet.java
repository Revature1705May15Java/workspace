package com.revature.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;
import com.revature.ers.util.TempLogger;

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
	    ArrayList<Request> requests = null;
	    if (u.isManager()) {
	      /*
	       * retrieve information for all reimbursement requests (and possibly all Users too)
	       * (maybe paginate the data and just retrieve up to a specific number of reimbursement requests)
	       */
	      requests = service.getRequests();
	    } else {
	      /*
	       * retrieve information for all reimbursement requests created by the current employee
	       * (possibly consider paginating the data)
	       */
	      requests = service.getRequestsByEmployee(u);
	    }
	    ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      
      String json = mapper.writeValueAsString(requests);
      response.setContentType("application/json");
      TempLogger.serverLog("sending: " + json);
      PrintWriter out = response.getWriter();
      out.println(json);
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
      Request result = null;
      
      if (u.isManager()) {
        /*
         * if the request body contains the necessary parameters, use them to update the Request specified by the parameters 
         * as the current manager and then send the JSON representation of the updated Request object, otherwise send an error code
         */
      } else {
        /*
         * retrieve parameters from request body and (if it contains the necessary fields) use its contents to add/create a Request 
         * as the current employee and then send the JSON representation of the created Request object, otherwise respond with error code
         */
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        String purpose = request.getParameter("purpose");
        
        if (amount != null && purpose != null) {
          result = service.createRequest(u, amount, purpose);
        }
        
        // how result is handled depends on what URI the request is sent to
        String uri = request.getRequestURI();
        switch (uri) {
        case "/ERS/user":
          ObjectMapper mapper = new ObjectMapper();
          mapper.registerModule(new JavaTimeModule());
          String json = mapper.writeValueAsString(result);
          response.setContentType("application/json");
          TempLogger.serverLog("sending: " + json);
          PrintWriter out = response.getWriter();
          out.println(json);
          break;
        case "/ERS/aux/user":
          break;
        }
        if (result == null) {
          
        } else if (uri.equals("/ERS/user")) {
          ObjectMapper mapper = new ObjectMapper();
          mapper.registerModule(new JavaTimeModule());
          String json = mapper.writeValueAsString(result);
          response.setContentType("application/json");
          TempLogger.serverLog("sending: " + json);
          PrintWriter out = response.getWriter();
          out.println(json);
        } else if (uri.equals("/ERS/aux/user")) {
          
        }
        
      }
    } else {
      /*
       * if there is no current user stored in the session, redirect to login page
       */
      response.sendRedirect("login");
    }
	}

}
