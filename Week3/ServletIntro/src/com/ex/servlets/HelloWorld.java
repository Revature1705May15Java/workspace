package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		/*
		 * in order to accept input from the user, we need to use the 
		 * request variable 
		 * 
		 * if we want to provide a response to the user
		 * we need to use the response variable 
		 * 
		 * the code that we write for the service method will be 
		 * considered the definition for the process 
		 */
		
		PrintWriter out = response.getWriter();
		// prints to screen 
		
		out.println("Java Servlets! Hello World!");
		
		
	
	}

}
