package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
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

			session.setAttribute("table", "-");		
			ServletContext context = request.getServletContext(); 
			
			
		
			context.getNamedDispatcher("HomeServlet"); 
		}
		
		public static void writeTable(String table)
		{
			ErsService service = new ErsService(); 
			BufferedWriter writer;
			
			try
			{		
				switch(table)	//adjust for employees 
				{
					case "pending-req":
					{
						writer =  new BufferedWriter(new FileWriter("pendingRequests.txt", true));
						// { "data": [
						writer.write("{\"data\":[");
						for(Request r : service.getPendingRequests())
						{
							Employee e = new Employee(); 
							e.setId(r.getRequesterId());
							
							e = service.getEmployee(e); 
							// [ "firstName", "lastName", "email", "amount", "date submit", "approve/deny"],
							writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
									"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
									r.getRequestDate() + "\",\"" + "\"]");	// what do for approve button 
						}
						// ]}
						writer.write("]}");
						break;
					}
					case "approve-req":
					{
						writer =  new BufferedWriter(new FileWriter("approvedRequests.txt", true));
						// { "data": [
						writer.write("{\"data\":[");
						for(Request r : service.getApprovedRequests())
						{
							Employee e = new Employee(); 
							e.setId(r.getRequesterId());
							
							e = service.getEmployee(e); 
							// [ "firstName", "lastName", "email", "amount", "date submit"
							writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
									"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
									r.getRequestDate() + "\"]");	// what do for approve button 
						}
						writer.write("]}");
						break; 
					}
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
}