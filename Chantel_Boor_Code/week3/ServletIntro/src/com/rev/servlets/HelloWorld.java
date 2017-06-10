package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
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
    public HelloWorld() 
    {
        super();
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		/*
		 * In order to accept input from the user we need to user the 
		 * request varible
		 * 
		 * if we want to send a response back to the user we use the 
		 * response varible
		 * 
		 * The code that we write for the service 
		 */
		
		PrintWriter out = response.getWriter();
		
		out.println("Java Servlets! Hello World!");
	}

}
