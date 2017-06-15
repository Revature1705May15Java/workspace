package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojo.User;
import com.ers.service.Service;

/**
 * Servlet implementation class EditInfoServlet
 */
@WebServlet("/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		session.removeAttribute("user");
		Service service = new Service();
		
		try{
			String temp = request.getParameter("newusername");
			if(temp != null) {
				u.setUsername(temp);
			}
			
			
			temp = request.getParameter("newpw");
			if(temp.equals(request.getParameter("newpw2")) && u.getPassword().equals(request.getParameter("oldpw"))){
				u.setPassword(temp);
			}
			else {
				request.setAttribute("editing", "fail");
				request.getRequestDispatcher("home").forward(request, response);
				return;
			}
			
			temp = request.getParameter("newfn");
			if(temp != null) u.setFn(temp);
			
			temp = request.getParameter("newln");
			if(temp != null) u.setLn(temp);
			
			service.editUser(u);
			request.setAttribute("user", u);
			
			request.setAttribute("editing", "success");
			request.getRequestDispatcher("home").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("editing", "fail");
			request.getRequestDispatcher("Home.ftl").forward(request, response);
		}
	}

}