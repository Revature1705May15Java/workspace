package com.bank.servlets;
//FREEMARKERBANK
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getRequestDispatcher("index.html").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String usr = request.getParameter("username");
		String pass = request.getParameter("password");
		User u = new User();
		Service service = new Service();
		HttpSession s = request.getSession(true);
		//request.setAttribute("login", "-");
		try{
			u = service.login(Integer.parseInt(usr),pass);
			if(u.getPw().contentEquals(pass) & u!=null){
				s = request.getSession(true);
				s.setAttribute("user", u);
				response.sendRedirect("home");
				//RequestDispatcher rd = request.getRequestDispatcher("Success.html");
				//rd.forward(request, response);
			}
			else{
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("/login.ftl").forward(request, response);
				//RequestDispatcher rd = request.getRequestDispatcher("Error.html");
//				rd.forward(request, response);
			}
			
			
		}catch(NullPointerException npe){
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("/login.ftl").forward(request, response);;
//			RequestDispatcher rd = request.getRequestDispatcher("Error.html");
			//npe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("/login.ftl").forward(request, response);;
			//RequestDispatcher rd = request.getRequestDispatcher("Error.html");
			//e.printStackTrace();
		}

	}

}