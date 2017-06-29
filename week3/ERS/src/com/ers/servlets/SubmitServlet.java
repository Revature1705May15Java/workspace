package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Request> allreqs = new ArrayList();
		System.out.println("last servlet running");
		String note,status;
		Service ser = new Service();
		Employee e;
		int id,Stateid;
		HttpSession s = request.getSession(true);
	
		id = Integer.parseInt(request.getParameter("reqid"));
		status = request.getParameter("status");
		
		System.out.println("THIS IS STATUS: "+ status);
		note = request.getParameter("note");
		if(status.equals("approve")){
			Stateid=1;
		}
		
		else if(status.equals("deny")){
			Stateid=2;
		}
		else{
			Stateid=0;
		}
		
		e = (Employee)s.getAttribute("emp");
		int managerid = e.getEid();
		ser.approvedeny(Stateid, note, id, managerid);
		allreqs = ser.ViewAllRequests();
		request.setAttribute("Requests", allreqs);
		RequestDispatcher rd = request.getRequestDispatcher("mHome.ftl");
		rd.forward(request, response);
		
	}

}