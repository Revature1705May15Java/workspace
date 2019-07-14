package com.reim.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.service.Service;


public class EmployeeServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Request> reqs=new ArrayList<Request>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Employee emp = new Employee();
		HttpSession s = request.getSession(true);
		
		emp = (Employee) s.getAttribute("Employee");
		reqs = emp.getEmployee_request();
		String fn = emp.getFn();
		String ln = emp.getLn();
		String uname = emp.getUname();
//		System.out.println(fn);
//		System.out.println(ln);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		request.setAttribute("uname", uname);
		request.setAttribute("requests", reqs);
//		System.out.println(request.getAttribute("firstname"));
//		System.out.println(request.getAttribute("lastname"));	
		request.getRequestDispatcher("/employeeHome.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String fname = request.getParameter("firstName");
//		System.out.println(fname);
//		String lname = request.getParameter("lastName");
//		String uname = request.getParameter("username");
//		String pw = request.getParameter("password");
//		Employee empl = new Employee();
//		HttpSession s = request.getSession(true);
		
//		empl = (Employee) s.getAttribute("Employee");
//		System.out.println(empl.toString());
//		Service service = new Service();
//		
//		
////		request.setAttribute("login", "-");
//		try{
//			Employee temp = service.updateInfo(empl, fname, lname, uname, pw);
//			if(temp!=null){
//	
//				s.setAttribute("Employee", temp);
//				request.setAttribute("update", "success");
////				RequestDispatcher rd = request.getRequestDispatcher("home");
////				rd.forward(request, response);
//			}
//			else{
////				RequestDispatcher rd = request.getRequestDispatcher("Error.html");
////				rd.forward(request, response);
//				request.setAttribute("update", "fail");
//				request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
//			}
//		}
//		catch(NullPointerException npe){
//			request.setAttribute("update", "fail");
//			request.getRequestDispatcher("employeeHome.ftl").forward(request, response);
////			response.sendRedirect("Error.html");
////		} catch (ServletException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
