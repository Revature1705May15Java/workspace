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
import service.ErsService;

/**
 * Servlet implementation class ResolveRequest
 */
@WebServlet("/ApproveRequestServlet")
public class ApproveRequestServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
       
    public ApproveRequestServlet() 
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
		Employee e = (Employee)session.getAttribute("employee");

		int id = Integer.parseInt(request.getParameter("reqid"));
		ErsService service = new ErsService(); 
		RequestDispatcher rd; 
		
		if(service.approveRequest(id, e))
		{
			session.setAttribute("approve", "pass");
        	rd = request.getRequestDispatcher("manager.ftl");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("approve", "fail");
        	rd = request.getRequestDispatcher("manager.ftl");
			rd.forward(request, response);
		}
	}

}
