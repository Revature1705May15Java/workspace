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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
	  HttpSession session = request.getSession();
	  User u = (User) session.getAttribute("user");
	  if (u != null) {
	    ArrayList<Request> pending = null;
	    ArrayList<Request> resolved = null;
	    if (u.isManager()) {
	      pending = service.getPendingRequests();
	      resolved = service.getResolvedRequests();
	    } else {
        pending = service.getPendingRequestsByEmployee(u);
        resolved = service.getResolvedRequestsByEmployee(u);
	    }
	    ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      
      String pendingJson = mapper.writeValueAsString(pending);
      String resolvedJson = mapper.writeValueAsString(resolved);
      String json = "{pending: " + pendingJson + ", resolved: " + resolvedJson + "}";
      response.setContentType("application/json");
      TempLogger.serverLog("sending: " + json);
      PrintWriter out = response.getWriter();
      out.println(json);
	  } else {
      response.sendRedirect("logout");
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
        Integer requestId = (request.getParameter("requestId") == null || request.getParameter("requestId").equals("")) ? null : Integer.parseInt(request.getParameter("requestId"));
        Boolean approved = (request.getParameter("state") == null) ? null : request.getParameter("state").equalsIgnoreCase("approved");
        String note = request.getParameter("note");
//        System.out.println("received: requestId = " + requestId + ", approved = " + approved + ", note = " + note);
        
        if (requestId != null && approved != null) {
          result = service.resolveRequest(requestId, u, approved, note);
//          System.out.println("resolved " + result);
        }
      } else {
        /*
         * retrieve parameters from request body and (if it contains the necessary fields) use its contents to add/create a Request 
         * as the current employee and then send the JSON representation of the created Request object, otherwise respond with error code
         */
        BigDecimal amount = (request.getParameter("amount") == null) ? null : new BigDecimal(request.getParameter("amount"));
        String purpose = request.getParameter("purpose");
//        System.out.println("received: amount = " + amount + ", purpose = " + purpose);
        
        if (amount != null && purpose != null) {
          result = service.createRequest(u, amount, purpose);
        }
      }
//      how result is handled depends on what URI the request is sent to
//      String uri = request.getRequestURI();
      
      if (result == null) {
        response.sendError(400, "The action you requested was unsuccessful.");
      } else /*if (uri.equals("/ERS/request"))*/ {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = mapper.writeValueAsString(result);
        response.setContentType("application/json");
        TempLogger.serverLog("sending: " + json);
        PrintWriter out = response.getWriter();
        out.println(json);
      }
        
    } else {
      response.sendRedirect("logout");
    }
	}

}
