package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true); 
		
		Employee employee = (Employee)session.getAttribute("employee"); 	// 
		session.setAttribute("employee", employee);
		RequestDispatcher rd; 
		
//		if(employee.getManagerId() == 0)	//not a Manager
//		{
//			rd = request.getRequestDispatcher("home.ftl");
//			rd.forward(request, response);	
//
//		}
//		else if(employee.getManagerId() == 1)	// a Manager
//		{
//			rd = request.getRequestDispatcher("manager.ftl"); 
//			rd.forward(request, response);
//		}
	}
}
