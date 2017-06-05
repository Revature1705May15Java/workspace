package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet 
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
		
		User user = (User)session.getAttribute("user"); 	// ???????
		session.setAttribute("user", user);

		RequestDispatcher rd = request.getRequestDispatcher("home.ftl");
		rd.forward(request, response);
	}

}
