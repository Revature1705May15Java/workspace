package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	HttpSession sess;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
	
	
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (sess == null || sess.getAttribute("user") == null) {
            response.sendRedirect("index.ftl"); // No logged-in user found, so redirect to login page.
        } else {
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            chain.doFilter(req, res);  
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email = request.getParameter("username");
		String pw = request.getParameter("password");
		
		request.setAttribute("login", "-");
		
		Service s = new Service();
		Employee e = new Employee();
		
		
		try
		{
			
			e = s.login(email,pw);
			sess = request.getSession(true);
			
			if(e.getEmployeeId() != 0)
			{
				//checks if user is manager and preforms appropriate display forward action
				if(e.getIsManager() == 1)
				{
					sess.setAttribute("user", e);
					request.setAttribute("name", e.getfName() + " " + e.getlName());
					request.setAttribute("add", "-");
					request.getRequestDispatcher("mHomeDataTable.ftl").forward(request, response);
				}
				else
				{
					sess.setAttribute("user", e);
					request.setAttribute("name", e.getfName() + " " + e.getlName());
					request.getRequestDispatcher("eHome.ftl").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("login","fail");
				request.getRequestDispatcher("index.ftl").forward(request, response);
				
			}
		}catch (NullPointerException n)
		{
			n.printStackTrace();
		}
		
		
	}

}
