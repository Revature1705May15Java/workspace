package com.ers.servlets;
//ERS
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myContextParam, name, pw;
		
		try{
			PrintWriter out = response.getWriter();
			
			//
			 myContextParam = request.getSession().getServletContext().getInitParameter("MyParam");
			 name = request.getParameter("username");
			 pw = request.getParameter("password");
			 
			 /*SET NAME and PW to getUser METHOD
			  * IF u.IsManager==0 go to employee
			  * Else go to Manager
			  */
			 
			 if(name.equals("emp")){
				 RequestDispatcher rd = request.getRequestDispatcher("eHome.html");
				 rd.forward(request, response);
			 }
			 else if(name.equals("man")){
				 RequestDispatcher rd = request.getRequestDispatcher("mHome.html");
				 rd.forward(request, response);
			 }
			
			out.println(myContextParam + " "+name+" "+ pw);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		}
	

}
