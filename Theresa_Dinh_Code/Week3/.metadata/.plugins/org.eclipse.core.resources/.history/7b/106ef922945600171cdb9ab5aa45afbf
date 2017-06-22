package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.Employee;
import pojos.Request;
import service.ErsService;

/**
 * Servlet implementation class TableDenyServlet
 */
@WebServlet({"/TableDenyServlet", "/deny"})
public class TableDenyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableDenyServlet() 
    	{
            super();
        }

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException 
    	{
    		
    	}

    	// creates string for pending tables 
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException 
    	{

    		ErsService service = new ErsService(); 
    		try(PrintWriter writer =  response.getWriter();)
    		{		

    			// { "data": [
    			String json = ""; 
    			json += "{\"data\":[";
    			ArrayList<Request> list = service.getDeniedRequests(); 
    					
    			for(int i = 0; i < list.size(); i++)
    			{
                    Request r = list.get(i); 
                    Employee e = service.getEmployee(r.getRequesterId()); 

                    // [ "firstName", "lastName", "email", "amount", "date submit", 
                    json += ("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
    						"\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
    						r.getRequestDate() + "\"]");
                    if(i == list.size()-1)
                        continue;
                    json += (",");
                }
                // ]}
                json += ("]}");
                System.out.println(json);
                writer.println(json); 
            }
    		catch(IOException e)
    		{
    			e.printStackTrace();
    		}
//    		context.getNamedDispatcher("HomeServlet"); 
    	}
}
