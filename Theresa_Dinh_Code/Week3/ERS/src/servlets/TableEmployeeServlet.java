package servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;
import pojos.Request;
import service.ErsService;

/**
 * Servlet implementation class TableEmployeeServlet
 */
@WebServlet({ "/TableEmployeeServlet", "/emptables" })
public class TableEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	   public TableEmployeeServlet() 
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
//
//			session.setAttribute("table", "-");		
//			ServletContext context = request.getServletContext(); 
//			context.getNamedDispatcher("HomeServlet"); 
			
			ErsService service = new ErsService(); 
			
			
			try(PrintWriter writer = response.getWriter();)
			{		
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void writeTable(String table)
		{
			
		}
}
