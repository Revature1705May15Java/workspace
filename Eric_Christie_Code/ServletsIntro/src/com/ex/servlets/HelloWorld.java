package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * in order to accept input from the user, we need to use the request variable.
     * 
     * if we want to provide a response to the user, we need to use the response variable.
     * 
     * the code that we write for the service method will be considered the definition for the process.
     */

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
      PrintWriter out = res.getWriter();
      out.println("Java Servlets! Hello World!");
    }
	
	

}
