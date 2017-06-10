package com.revature.ers.servlets;

import com.revature.ers.pojos.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.revature.ers.servlets.LoginServlet.authenticate;
import static com.revature.ers.servlets.LoginServlet.authenticateEmployee;

public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authenticate(request, response)) {
            if ( ((User)request.getSession().getAttribute("user")).isManager()) {
                request.getRequestDispatcher("/ManagerHome").forward(request, response);
            } else {
                request.getRequestDispatcher("/EmployeeHome").forward(request, response);
            }
        } else {
            response.sendRedirect("/Login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
