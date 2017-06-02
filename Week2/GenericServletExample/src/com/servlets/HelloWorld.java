package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// need this annotation to work
@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet {

	public HelloWorld(){
		super();
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * in order to accept input provide from the user, 
		 * we need to use the request variable
		 * if we want to provide a response to the user,
		 * we need to use the response variable
		 * the code that we write for the service method 
		 * will be considered the definition to be processed
		 */
		
		PrintWriter out = response.getWriter();
		// prints to screen 
		
		out.println("Java Servlets! Helloooo World!");
		
	}

}
