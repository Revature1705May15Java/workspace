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
       * retrieve the account settings/information for the current user (and MAYBE change the "user" attribute of the current session)
       * (this method will likely not be used directly by the user)
       */
      User current = service.getUserById(u.getId());
      
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      
      String json = mapper.writeValueAsString(current);
      response.setContentType("application/json");
      System.out.println("sending: " + json);
      PrintWriter out = response.getWriter();
      out.println(json);
    } else {
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
      /*
       * parse request body and (if there is nothing wrong with it) use its contents to update the current user's account settings/information
       */
      System.out.println("/ERS/settings - printing request cookies, headers, and parameters:");
      Cookie[] cookies = request.getCookies();
      System.out.println("\nCOOKIES");
      for (Cookie c: cookies) {
        System.out.println(c);
      }
      System.out.println("\nHEADERS");
      for (Enumeration<String> headers = request.getHeaderNames(); headers.hasMoreElements();) {
        String h = headers.nextElement();
        System.out.println(h + ": " + request.getHeader(h));
      }
      System.out.println("\nPARAMETERS");
      for (Enumeration<String> params = request.getParameterNames(); params.hasMoreElements();) {
        String p = params.nextElement();
        System.out.println(p + ": " + request.getParameter(p));
      }

      String email = request.getParameter("email");
      System.out.println("email = " + email);
      String password = request.getParameter("password");
      password = password.equals("") ? null : password;
      System.out.println("password = " + password);
      String confirm = request.getParameter("confirm");
      confirm = confirm.equals("") ? null : confirm;
      System.out.println("confirm = " + confirm);
      String firstname = request.getParameter("firstname");
      System.out.println("firstname = " + firstname);
      String lastname = request.getParameter("lastname");
      System.out.println("lastname = " + lastname);
      Boolean emailAlertsOn = request.getParameter("emailAlerts") != null;
      System.out.println("emailAlertsOn = " + emailAlertsOn);
      
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());
      
      if (password != null) {
        if (password.equals(confirm)) {
          User updated = service.updateUserInformation(u.getId(), email, password, firstname, lastname, emailAlertsOn);
        } else {
          response.sendError(400, "Password and password confirmation must match.");
        }
      } else {
        User updated = service.updateUserInformation(u.getId(), email, password, firstname, lastname, emailAlertsOn);
      }
    } else {
      response.sendRedirect("login");
    }
	}

}
