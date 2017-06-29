package com.ers.servlets;
//ERS
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

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
		System.out.println("LOGIN SERVLET RUNNING");
		try{
			PrintWriter out = response.getWriter();

			//
			myContextParam = request.getSession().getServletContext().getInitParameter("MyParam");
			name = request.getParameter("username");
			pw = request.getParameter("password");
			HttpSession sess = request.getSession(true);
			Service s = new Service();
			Employee e = new Employee();

			e = s.login(name, pw);
			System.out.println("HIIII "+e.toString());



			if(e.getIsmanager() == 0 & e.getEid()==0){
				/**Add  functionality 
				 * to show error message
				 */

				System.out.println("Invalid user"); 
			}

			else if(e.getIsmanager()==0){
				ArrayList <Request> rs, ors, crs;
				rs = s.viewRequestbyId(e.getEid());
				ors = s.viewOpenRequestById(e.getEid());
				crs = s.viewResolvedById(e.getEid());
				
				System.out.println("Requests "+rs+"\n"
						+ ors+"\n"
								+ crs+"");
				
				
				
				//sess = request.getSession(true);
				sess.setAttribute("emp", e);
				sess.setAttribute("empln", e.getLastname());
				sess.setAttribute("Requests", rs);
				sess.setAttribute("OpenReqs", ors);
				sess.setAttribute("ClosedReqs", crs);
				
				
				//request.getRequestDispatcher("eHome.ftl");
				RequestDispatcher rd = request.getRequestDispatcher("eHome.ftl");
				rd.forward(request, response);

				//response.sendRedirect("eHome.ftl");
			}

			else if(e.getIsmanager()==1){
				if(pw.contentEquals(e.getPassword())){
					ArrayList <Request> rs, ors, crs;
					ArrayList <Employee> el;
					rs = s.ViewAllRequests();
					ors = s.viewOpenRequestById(e.getEid());
					crs = s.viewResolvedById(e.getEid());
					el = s.ViewAllEmployees();
					//sess = request.getSession(true);
					sess.setAttribute("emp", e);
					sess.setAttribute("empln", e.getLastname());
					sess.setAttribute("Requests", rs);
					sess.setAttribute("OpenReqs", ors);
					sess.setAttribute("ClosedReqs", crs);
					sess.setAttribute("AllEmps", el);
					
					RequestDispatcher rd = request.getRequestDispatcher("mHome.ftl");
					rd.forward(request, response);
					
				}
				
			}




			out.println(myContextParam + " "+name+" "+ pw);

		}catch(Exception e){
			e.printStackTrace();
		}



	}


}