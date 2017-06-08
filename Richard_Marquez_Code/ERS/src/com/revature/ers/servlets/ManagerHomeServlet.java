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
import java.util.List;

import static com.revature.ers.servlets.LoginServlet.authenticateManager;

public class ManagerHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 5L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticateManager(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);

        List<ReimbursementRequest> allRequests = Service.getInstance().getAllPendingRequests();
        request.setAttribute("pendingRequests", allRequests);

        List<User> allEmployees = Service.getInstance().getAllEmployees();
        request.setAttribute("allEmployees", allEmployees);

        request.setAttribute("pageTitle", "Manager Home");
        request.getRequestDispatcher("/managerHome.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
