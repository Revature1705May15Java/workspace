package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

public class ProcessRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		if(emp==null){
			resp.sendRedirect("logout");
		}
		System.out.println(req.getParameter("Filter"));
		if(req.getParameter("Filter")!=null){
			req.getRequestDispatcher("filter").forward(req, resp);
		}else{
		ArrayList<Request> reqs=(ArrayList<Request>)session.getAttribute("modrequests");
		ArrayList<Integer> approved=new ArrayList<Integer>();
		ArrayList<Integer> denied=new ArrayList<Integer>();
		ArrayList<String> approvenotes=new ArrayList<String>();
		ArrayList<String> denynotes = new ArrayList<String>();
		for(int i=0;i<reqs.size();i++){
			int requestid=reqs.get(i).getRequestid();
			String requestidstr=""+requestid;
			if(reqs.get(i).getName().equals("Pending")){
				String approval=req.getParameter(requestidstr);
				if(approval!=null){
					String note=req.getParameter(requestidstr+"n");
					if(approval.equals("Approve")){
						approved.add(requestid);
						if(note!=null){
							approvenotes.add(note);
						}else{
							approvenotes.add("");
						}
					}else if(approval.equals("Deny")){
						denied.add(requestid);
						if(note!=null){
						denynotes.add(note);
						}else{
							denynotes.add("");
						}
					}
				}
			}
		}
		int[] approves=new int[approved.size()];
		int[] denies=new int[denied.size()];
		String[] approvenote = new String[approves.length];
		String[] denynote= new String[denies.length];
		for(int i=0;i<approves.length;i++){
			approves[i]=approved.get(i);
			approvenote[i]=approvenotes.get(i);
		}
		for(int i=0;i<denies.length;i++){
			denies[i]=denied.get(i);
			denynote[i]=denynotes.get(i);
		}
		if(approves.length>0){
		Service.approveRequests(approves,approvenote,emp.getId());
		}
		if(denies.length>0){
		Service.denyRequests(denies,denynote,emp.getId());
		}
		if(emp!=null&&emp.getIsmanager()==0){
			resp.sendRedirect("home2");
		}else if(emp!=null&&emp.getIsmanager()==1){
			ArrayList<Request> newreqs=Service.getAllRequests();
			session.setAttribute("requests", newreqs);
			session.setAttribute("modrequests", newreqs);
			resp.sendRedirect("home");
		}else{
			resp.sendRedirect("logout");
		}
		}
	}

}