package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Requests;
import com.ers.service.Service;

/**
 * Servlet implementation class displayEmployees
 */
@WebServlet("/displayEmployees")
public class displayEmployees extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//gets seesion attribute from login page
		Service s = new Service ();
		
		ArrayList <Employee> elist = s.getAllEmployee();
		
		//start json string	
		PrintWriter out = response.getWriter();
		String json = "{ \"demo\":[" ;
		
		//counter to add commas to all but last element
		int counter = 0;
		
		
		if(elist.get(0).getEmployeeId() != 0)
		{
			//creates a json string for non empty array
			for(Employee e:elist)
			{
				json += "[\" "+ e.getEmployeeId()+ "\",\""+e.getfName()+"\","+"\""+e.getlName()+
						 "\",\""+s.displayIsmanger(e.getIsManager())+"\",\""+e.getEmail()+"\"]";
				
				
				
				//comma between elements
				if(counter != elist.size()-1)
				{
					json += ",";
				}
				
				counter++;
			}
			
			//end of json and print
			json += "]}";
			out.println(json);
		}
		else
		{
			//creates an empty table if nothing is found
			json += "[\"1 \",\" 2\",\" 3\",\" 4\",\"5\",\"6\",\"7\",\"8\",\"9\"]]}";
			out.println(json);
		}
		
	}

}
