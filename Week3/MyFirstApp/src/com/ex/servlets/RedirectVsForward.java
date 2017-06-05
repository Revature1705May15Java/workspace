package com.ex.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectVsForward
 */
@WebServlet("/RedirectVsForward")
public class RedirectVsForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*
 * redirect vs forward
 * 	- Two ways to send the client a response
 * 	- Big interview question
 * 
 * 	1) Redirect - HttpServletResponse.redirect
 * 
 * 	2) Forward - HttpServletRequest.getRequestDispatcher
 * 				- RequestDispatcher.forward
 * 
 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException{
		System.out.println("response");
		/*
		 * redirect
		 * -give a url or html page (any resource will do)
		 * -the response will tell the client to send another request for this resource
		 * -Pro: Can manipulate the url
		 * -Con: slower as total of 2 requests
		 */ 
//		 resp.sendRedirect("RedirectForward.html");
		 
		 /*
		  * forward
		  * -give a html page
		  * - the contents of the specified resource will be sent back to the client
		  * - Pro: Faster as total of 1 request
		  * - Con: Url doesn't change
		  */
		RequestDispatcher rd = req.getRequestDispatcher("RedirectForward.html");
		rd.forward(req, resp);
		
		
		
	}


}