package com.ex.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletConfigExample extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
 
		System.out.println("ServletConfigExample");
		 
		String firstVal = getInitParameter("name1");
		System.out.println("\tFirst Value = " + firstVal);
		
		String secondValue = getInitParameter("favoriteColor");
		System.out.println("\tFavorite Color: " + secondValue);
		
		System.out.println("This servlet also has url: " +  getServletContext().getInitParameter("url") );
		
	}



}
