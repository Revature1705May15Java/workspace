package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Person;

@WebServlet("/getBetterJson")
public class AjaxObjectMappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person john = new Person("John", 32);
		
		// Object Mapper will convert java object to string
		ObjectMapper mapper = new ObjectMapper();
		String johnJson = mapper.writeValueAsString(john);
		
		System.out.println(johnJson);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJson);
	}

}
