package com.revature.ers.servlets;

import com.revature.ers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 12L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle", "Forgot Password");

        String email = request.getParameter("email");

        if (email != null && !email.isEmpty()) {
            boolean result = Service.getInstance().resetPassword(email);
            if (result) {
                request.setAttribute("successMsg", "You have been sent an email with a temporary password.");
            } else {
                request.setAttribute("errorMsg", "You were unable to reset your password.");
            }
            request.getRequestDispatcher("/login.ftl").forward(request, response);
        } else {
            request.getRequestDispatcher("/forgotPassword.ftl").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
