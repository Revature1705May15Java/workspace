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
import service.ErsService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() 
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
		String email = request.getParameter("email"); // employee email 
		String password = request.getParameter("password"); 
		Employee employee; 
		ErsService service = new ErsService(); 
		HttpSession session = request.getSession(true); 
		session.setAttribute("login", "-");
		
		try
		{
			boolean employeeExists = (service.getEmployee(new Employee(email, password)) != null); 
			
			if(employeeExists)
			{ 
				// add a check for managerid to redirect to manager's page  
				employee = service.getEmployee(new Employee(email, password)); 
				RequestDispatcher rd; 
				

				session.setAttribute("employee", employee);
				
				if(employee.getManagerId() == 0)	//not a Manager
				{
					session.setAttribute("manager", "false");
					rd = request.getRequestDispatcher("home.ftl");
					rd.forward(request, response);
//					response.sendRedirect("home");

				}
				else if(employee.getManagerId() == 1)	// a Manager
				{
					session.setAttribute("manager", "true");
					rd = request.getRequestDispatcher("manager.ftl"); 
					rd.forward(request, response);
//					ServletContext context = request.getServletContext(); 
//					rd = context.getNamedDispatcher("HomeServlet"); 
				}
			}
			else
			{
				session.setAttribute("login", "fail");
				RequestDispatcher rd = request.getRequestDispatcher("login.ftl");
				rd.forward(request, response);
				
//				ServletContext context = request.getServletContext(); 
//				rd = context.getNamedDispatcher("HomeServlet"); 
			}
		}
		catch(NullPointerException n)
		{
			n.printStackTrace();
		}
	}
}
