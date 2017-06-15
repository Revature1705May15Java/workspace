package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AJAXJackson
 */
@WebServlet("/getBetterJSON")
public class AJAXJacksonObjectMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person john = new Person("John", 32);  

		// Object mapper will convert java object to string
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(john);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
