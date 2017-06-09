package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AjaxJacksonObjectMapping
 */
@WebServlet("/getBetterJSON")
public class AjaxJacksonObjectMapping extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	Person john = new Person("John", 32);
	
	// Object Mapper will convert java object to string
	ObjectMapper mapper = new ObjectMapper();
	String johnJSON = mapper.writeValueAsString(john);
	System.out.println(johnJSON);
	
	response.setContentType("application/json");
	PrintWriter out = response.getWriter();
	out.write(johnJSON);
	}

}
