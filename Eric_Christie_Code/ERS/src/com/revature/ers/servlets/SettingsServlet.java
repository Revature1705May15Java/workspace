package com.revature.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;
import com.revature.ers.util.TempLogger;

/**
 * Servlet implementation class SettingsServlet.
 * This servlet is for a user to view and change his account settings.
 * It should behave the same for employees and managers:
 * - GET retrieve the current user's account settings/information
 * - POST update the current user's account settings/information with any new information provided
 */
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      /*
       * retrieve the account settings/information for the current user and change the "user" attribute of the current session)
       * (this method will likely not be used directly by the user)
       */
      User current = service.getUserById(u.getId());
      if (current != null) {
        session.setAttribute("user", current);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        
        String json = mapper.writeValueAsString(current);
        response.setContentType("application/json");
        TempLogger.serverLog("sending: " + json);
        PrintWriter out = response.getWriter();
        out.println(json);
      }
      
      
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
      /*
       * parse request body and (if there is nothing wrong with it) use its contents to update the current user's account settings/information
       */
      TempLogger.serverLog("/ERS/settings - printing request cookies, headers, and parameters:");
      Cookie[] cookies = request.getCookies();
      TempLogger.serverLog("\nCOOKIES");
      for (Cookie c: cookies) {
        TempLogger.serverLog("Cookie: " + c.getName() + " = " + c.getValue());
      }
      TempLogger.serverLog("\nHEADERS");
      for (Enumeration<String> headers = request.getHeaderNames(); headers.hasMoreElements();) {
        String h = headers.nextElement();
        TempLogger.serverLog(h + ": " + request.getHeader(h));
      }
      TempLogger.serverLog("\nPARAMETERS");
      for (Enumeration<String> params = request.getParameterNames(); params.hasMoreElements();) {
        String p = params.nextElement();
        TempLogger.serverLog(p + ": " + request.getParameter(p));
      }

      String email = request.getParameter("email");
      TempLogger.serverLog("email = " + email);
      String password = request.getParameter("password");
      password = password.equals("") ? null : password;
      TempLogger.serverLog("password = " + password);
      String confirm = request.getParameter("confirm");
      confirm = confirm.equals("") ? null : confirm;
      TempLogger.serverLog("confirm = " + confirm);
      String firstname = request.getParameter("firstname");
      TempLogger.serverLog("firstname = " + firstname);
      String lastname = request.getParameter("lastname");
      TempLogger.serverLog("lastname = " + lastname);
      Boolean emailAlertsOn = request.getParameter("emailAlerts") != null;
      TempLogger.serverLog("emailAlertsOn = " + emailAlertsOn);
      
      User updated = null;
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      
      if (password != null) {
        if (password.equals(confirm)) {
          updated = service.updateUserInformation(u, email, password, firstname, lastname, emailAlertsOn);
        } else {
          response.sendError(400, "Password and password confirmation must match.");
        }
      } else {
        updated = service.updateUserInformation(u, email, password, firstname, lastname, emailAlertsOn);
      }
      if (updated != null) {
        session.setAttribute("user", updated);
        String json = mapper.writeValueAsString(updated);
        response.setContentType("application/json");
        TempLogger.serverLog("sending: " + json);
        PrintWriter out = response.getWriter();
        out.println(json);
      } else {
        response.sendError(400, "Account settings update failed.");
      }
      
    } else {
      response.sendRedirect("logout");
    }
	}

}
