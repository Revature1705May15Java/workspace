package com.revature.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class RegistrationServlet.
 * This servlet should only be accessible to managers. 
 * If the current user is an employee, requests to this servlet should return an error status code.
 * If the current user is a manager:
 * - POST registers an account for a new user
 * 
 * -- having GET retrieve the account information of all users may be worth considering
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
         * retrieve the account information for all employees, all managers, or all users
         */
        System.out.println("\nTESTING JACKSON");
        ArrayList<User> employees = service.getEmployees();
        ArrayList<User> managers = service.getManagers(); // TODO decide whether or not to send this information
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        
        String employeesJson = mapper.writeValueAsString(employees);
        String managersJson = mapper.writeValueAsString(managers);
        String json = "{employees: " + employeesJson + ", managers: " + managersJson + "}";
        response.setContentType("application/json");
        System.out.println("employees: " + employeesJson);
        System.out.println("managers: " + managersJson);
        System.out.println("all users: " + json);
        PrintWriter out = response.getWriter();
        out.println(json);
      } else {
        response.sendError(403, "You do not have the necessary permissions for this.");
      }
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
      if (u.isManager()) {
        /*
         * Register a new user
         */
        
        System.out.println("/ERS/user - printing request cookies, headers, and parameters:");
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
        
//        this is what this servlet method should actually do when it receives a request
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        Boolean isManager = request.getParameter("accountType").equals("manager");
        User noob = service.registerUser(email, firstname, lastname, isManager);
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        
        String json = mapper.writeValueAsString(noob);
        response.setContentType("application/json");
        System.out.println("sending: " + json);
        PrintWriter out = response.getWriter();
        out.println(json);
      } else {
        response.sendError(403, "You do not have the necessary permissions for this.");
      }
    } else {
      response.sendRedirect("login");
    }
	}

}
