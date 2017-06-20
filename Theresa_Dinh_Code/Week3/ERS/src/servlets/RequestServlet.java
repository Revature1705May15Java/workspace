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

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet({ "/RequestServlet", "/request" })
public class RequestServlet extends HttpServlet 	// DONE!!!!
{
	private static final long serialVersionUID = 1L;
       

    public RequestServlet() 
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
		ErsService service = new ErsService(); 
		RequestDispatcher rd; 
		double amount = Double.parseDouble(request.getParameter("amount")); 
		String purpose = request.getParameter("purpose"); 
		
		session.setAttribute("request", "-");
		
		if(service.submitRequest(amount, purpose, employee.getEmail()))
		{
			session.setAttribute("request", "pass");
			rd = request.getRequestDispatcher("submission.ftl");
			rd.forward(request, response);
			ServletContext context = request.getServletContext(); 
			context.getNamedDispatcher("HomeServlet"); 
		}
		else
		{
			session.setAttribute("request", "fail");
			rd = request.getRequestDispatcher("submission.ftl");
			rd.forward(request, response);
			ServletContext context = request.getServletContext(); 
			context.getNamedDispatcher("HomeServlet"); 
		}
		
	}

}