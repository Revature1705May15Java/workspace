package com.revature.ers.servlets;

import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.revature.ers.servlets.LoginServlet.authenticate;
import static com.revature.ers.servlets.LoginServlet.authenticateEmployee;

public class EmployeeAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 7L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticate(request, response)) {
            response.sendRedirect("/Login");
            return;
        }


        if (request.getParameter("submit") != null) {
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            User updateResult = Service.getInstance().updateUser(user, email, password, firstName, lastName);

            if (updateResult != null) {
                session.setAttribute("user", updateResult);
                response.sendRedirect("/Home");
            } else {
                response.sendRedirect("/Login");
            }
            return;
        }

//        response.sendRedirect("/Home");
        request.setAttribute("pageTitle", "Employee Account");
        request.getRequestDispatcher("/employeeAccount.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

