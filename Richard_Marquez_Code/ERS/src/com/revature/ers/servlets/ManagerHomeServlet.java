package com.revature.ers.servlets;

import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 5L;

    private boolean authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        if (user != null && user.isManager()) {
            result = true;
        }

        return result;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticate(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        Service svc = new Service();
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("/managerHome.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
