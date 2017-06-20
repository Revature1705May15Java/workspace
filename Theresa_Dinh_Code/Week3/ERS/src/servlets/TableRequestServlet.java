package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class TableRequestServlet
 */
@WebServlet({ "/TableRequestServlet", "/reqtables" })
public class TableRequestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;   
	
    public TableRequestServlet() 
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
	
		ErsService service = new ErsService(); 
		
//		String table = (String)session.getAttribute("table"); 
		String table = request.getParameter("table"); 
		ServletContext context = request.getServletContext(); 
		
		BufferedWriter writer;
		try
		{		
			switch(table)
			{
				case "pending-req":
				{
					System.out.println("case triggered");
					writer =  new BufferedWriter(
							new FileWriter("ERS/src/data/pendingRequests.json", false));
					
					// { "data": [
					writer.write("{\"data\":[");
					ArrayList<Request> list = service.getPendingRequests(); 
					
					for(int i = 0; i < list.size(); i++)
					{
						Request r = list.get(i); 
						Employee e = service.getEmployee(r.getRequesterId()); 
						
						// [ "firstName", "lastName", "email", "amount", "date submit", "approve/deny"],
						writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
								"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
								r.getRequestDate() + "\",\"" + "\"]");	// what do for approve button 
						if(i == list.size()-1)
							continue;
						writer.write(",");
					}
					// ]}
					writer.write("]}");
					break;
				}
				case "approve-req":
				{
					System.out.println("case triggered");
					writer =  new BufferedWriter(
							new FileWriter("src/data/approvedRequests.txt", false));
					ArrayList<Request> list = service.getApprovedRequests(); 
					
					// { "data": [
					writer.write("{\"data\":[");
					
					for(int i = 0; i < list.size(); i++)
					{
						Request r = list.get(i); 
						Employee e = service.getEmployee(r.getRequesterId()); 
						// [ "firstName", "lastName", "email", "amount", "date submit"
						writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
								"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
								r.getRequestDate() + "\"]");	// what do for approve button 
						if(i == list.size()-1)
							continue;
						writer.write(",");
					}
					writer.write("]}");
					break; 
				}
				case "deny-req":
				{
					writer =  new BufferedWriter(
							new FileWriter("src/data/deniedRequests.txt", false));
					ArrayList<Request> list = service.getDeniedRequests(); 
					
					// { "data": [
					writer.write("{\"data\":[");
					
					for(int i = 0; i < list.size(); i++)
					{
						Request r = list.get(i); 
						Employee e = service.getEmployee(r.getRequesterId()); 
						// [ "firstName", "lastName", "email", "amount", "date submit"
						writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
								"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
								r.getRequestDate() + "\"]");	// what do for approve button 
						if(i == list.size()-1)
							continue;
						writer.write(",");
					}
					writer.write("]}");
					break; 
				}
				case "all-req":
				{
					writer =  new BufferedWriter(
							new FileWriter("src/data/allRequests.txt", false));
					ArrayList<Request> list = service.getAllRequests(); 
					
					// { "data": [
					writer.write("{\"data\":[");
					
					for(int i = 0; i < list.size(); i++)
					{
						Request r = list.get(i); 
						Employee e = service.getEmployee(r.getRequesterId()); 
						// [ "firstName", "lastName", "email", "amount", "date submit"
						writer.write("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
								"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
								r.getRequestDate() + "\",\"");	// what do for approve button 
						if(r.getStatusId() == 0)
							writer.write("Pending\"]");
						else if(r.getStatusId() == 1)
						{
							writer.write("Approved\"]");
						}
						else if(r.getStatusId() == 2)
						{
							writer.write("Denied\"]");
						}
						if(i == list.size()-1)
							continue;
						writer.write(",");
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
		context.getNamedDispatcher("HomeServlet"); 
	}
}
