package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import pojos.Employee;
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
    	ServletContext context = request.getServletContext(); 
        ErsService service = new ErsService(); 


        try(PrintWriter writer = response.getWriter();)
        {		
            String json = "";
            json += "{\"data\":["; 

            ArrayList<Employee> list = service.getAllEmployees(); 


            for(int index = 0; index < list.size(); index++)
            {
                Employee e = list.get(index); 

                json += ("[\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
                    "\",\"" + e.getEmail() + "\",\"");

                if(e.getManagerId() == 1)
                {
                    json += "Manager\"]";
                }
                else
                {
                    json += "Employee\"]";
                }

                if(index == list.size()-1)
                    continue;
                json += (",");
            }
            // ]}
            json += ("]}");
            writer.println(json); 
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
		context.getNamedDispatcher("HomeServlet"); 

    }
}
