package com.rev.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rev.pojo.Request;
import com.rev.pojo.User;
import com.rev.service.Service;

public class ServletSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Service serv = new Service();
	
    public ServletSort() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		int id = 4;
		int rst = 4;
		int rid = 0;
		
		try{
			id = Integer.parseInt(request.getParameter("state"));
		}catch(NumberFormatException e){
			
		}
		
		try{
			rst = Integer.parseInt(request.getParameter("reqState"));
			rid = Integer.parseInt(request.getParameter("reqID"));
		}catch(NumberFormatException e){
			
		}
//		System.out.println("request id = " + rid);
//		System.out.println("State id = " + id);
//		
//		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		String note = request.getParameter("note");
		
		if(u.getIsBoss()==1){
			if(rst==2){//approve or deny a request
				serv.approveRequest(rid, rst, u.getId(), note);
				System.out.println("approved");
			}else if(rst==3){
				serv.approveRequest(rid, rst, u.getId(), note);
				System.out.println("deny");
			}
			
			//updates the amount of each request as shown on the admin page
			request.setAttribute("allReq", serv.allRequested());
			request.setAttribute("allPend", serv.allPending());
			request.setAttribute("allAppr", serv.allResolved());
			request.setAttribute("allDen", serv.allDenied());
			
			if(id==1 || id==2 ||id==3){//get sorted arrayList
				accs = serv.getAllRequestsByStateId(id);
			}else{
				accs = serv.getAllRequests();
			}
			
			request.setAttribute("requests", accs);
			request.getRequestDispatcher("boss.ftl").forward(request, response);
		}else{
			if(id==1 || id==2 ||id==3){
				accs = serv.getUserRequestsByStateId(u, id);
			}else{
				accs = serv.getUserRequests(u);
			}
			
			request.setAttribute("requests", accs);
			request.getRequestDispatcher("user.ftl").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		ArrayList<Request> accs = new ArrayList<Request>();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		int id = 4;
		int rst = 4;
		int rid = 0;
		
		try{
			id = Integer.parseInt(request.getParameter("state"));
		}catch(NumberFormatException e){
			
		}
		
		try{
			rst = Integer.parseInt(request.getParameter("reqState"));
			rid = Integer.parseInt(request.getParameter("reqID"));
		}catch(NumberFormatException e){
			
		}
//		System.out.println("request id = " + rid);
//		System.out.println("State id = " + id);
//		
//		System.out.println(u.toString());
		
		String fn = u.getFn();
		String ln = u.getLn();
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		String note = request.getParameter("note");
		
		if(u.getIsBoss()==1){
			if(rst==2){//approve or deny a request
				serv.approveRequest(rid, rst, u.getId(), note);
				System.out.println("approved");
			}else if(rst==3){
				serv.approveRequest(rid, rst, u.getId(), note);
				System.out.println("deny");
			}
			
			//updates the amount of each request as shown on the admin page
			request.setAttribute("allReq", serv.allRequested());
			request.setAttribute("allPend", serv.allPending());
			request.setAttribute("allAppr", serv.allResolved());
			request.setAttribute("allDen", serv.allDenied());
			
			if(id==1 || id==2 ||id==3){//get sorted arrayList
				accs = serv.getAllRequestsByStateId(id);
			}else{
				accs = serv.getAllRequests();
			}
			
			request.setAttribute("requests", accs);
			request.getRequestDispatcher("boss.ftl").forward(request, response);
		}else{
			if(id==1 || id==2 ||id==3){
				accs = serv.getUserRequestsByStateId(u, id);
			}else{
				accs = serv.getUserRequests(u);
			}
			
			request.setAttribute("requests", accs);
			request.getRequestDispatcher("user.ftl").forward(request, response);
		}
		
	}

}
