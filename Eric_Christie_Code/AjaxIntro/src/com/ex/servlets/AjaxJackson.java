package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AjaxJackson
 */
@WebServlet("/AjaxJackson")
public class AjaxJackson extends HttpServlet {
  private static final long serialVersionUID = 8790821443798826090L;

  /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ArrayList<String> interests = new ArrayList<>();
	  interests.add("stuff");
	  interests.add("other stuff");
	  interests.add("even more stuff");
	  
	  Person guy = new Person("Guy", LocalDateTime.now(), new BigDecimal("50000.00"), interests);
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writeValueAsString(guy);
	  System.out.println(json);
	  
	  response.setContentType("application/json");
	  PrintWriter out = response.getWriter();
	  out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);
	}

}
