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

@WebServlet("/getBetterJSON")
public class AjaxJackson extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Person john = new Person("john", 32);
		//convert object to string
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(john);
		resp.setContentType("application.json");
		PrintWriter out = resp.getWriter();
		out.write(johnJSON);
	}
}
