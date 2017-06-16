package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet 	// portal hub, directs to other servlets as needed 
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
		
		Employee employee = (Employee)session.getAttribute("employee"); 	
//		session.setAttribute("employee", employee);
		RequestDispatcher rd; 
		
		session.setAttribute("choice", "-");
		
		String choice = (String)session.getAttribute("choice"); 
		ServletContext context = request.getServletContext(); 
		
		switch(choice)
		{
			case "submit-new": 
			{
				rd = request.getRequestDispatcher("submission.ftl"); 
				rd.forward(request, response);
				context.getNamedDispatcher("RequestServlet"); 
				break; 
			}
			case "update-prof":
			{
				rd = request.getRequestDispatcher("employees.ftl"); 
				rd.forward(request, response);
				context.getNamedDispatcher("ProfileServlet"); 
				break; 
			}
			case "logout":
			{
				rd = request.getRequestDispatcher("logout.ftl"); 
				rd.forward(request, response);
				context.getNamedDispatcher("LogoutServlet"); // make logout servlet 
			}
		}
	}
}
