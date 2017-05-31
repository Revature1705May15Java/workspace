package com.rev.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/FirstHttpServlet")
public class FirstHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("served at: ").append(request.getContextPath());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");

        out.println("<h3>Reading query str data</h3>");

        out.println("<div>");
        out.println("<p>first name: " + fName + "</p>");
        out.println("<p>last name: " + lName + "</p>");
        out.println("</div>");



        out.println("<h3> Reading query str data using Enumeration getParameterNames() method</h3>");
        Enumeration<String> paramNames = request.getParameterNames();

        out.println("<div>");
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = request.getParameter(paramName);

            out.println("<p>param raame: " + paramName +
                " param val: " + paramValue + "</p>");
        }
        out.println("</div>");



        Map<String, String[]> paramMap = request.getParameterMap();
        Set<String> paramNameSet = paramMap.keySet();

        out.println("<h3> Reading query str data using maps</h3>");
        out.println("<div>");
        for (String paramName : paramNameSet) {
            String[] paramValues = paramMap.get(paramName);
            out.println("<p>" + paramName + " : ");
            for (int i = 0; i < paramValues.length; i++) {
                out.println(paramValues[i]);
            }
            out.println("</p>");
        }
        out.println("</div>");

    }

}
