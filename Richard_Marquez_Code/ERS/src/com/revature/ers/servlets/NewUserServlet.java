package com.revature.ers.servlets;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.ers.servlets.LoginServlet.authenticateManager;

public class NewUserServlet extends HttpServlet {
    private static final long serialVersionUID = 10L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticateManager(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        Service svc = Service.getInstance();
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        boolean isManager = Boolean.parseBoolean(request.getParameter("isManager"));

        User newUser = svc.addUser(email, firstName, lastName, isManager);

        if (newUser != null) {
            response.sendRedirect("/ManagerHome");
        } else {
            PrintWriter out = response.getWriter();
            out.println("Failed to create new user");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
