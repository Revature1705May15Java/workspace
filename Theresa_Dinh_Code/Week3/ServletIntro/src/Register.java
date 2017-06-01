

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("pwd"); 
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
//		out.println("username: " + username + "<br>");
//		out.println("password: " + password);
		
		
		Map<String, String[]> paramMap = request.getParameterMap(); 
		Set<String> paramNameset = paramMap.keySet(); 
		
		out.println("<div>"); 
		for(String paramName : paramNameset)
		{
			String[] paramValues = paramMap.get(paramName); 
			out.println("<p>" + paramName + ": ");
			for(int i = 0; i < paramValues.length; i++)
			{
				out.println(paramValues[i]);
			}
			out.println("</p>"); 
		}
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
