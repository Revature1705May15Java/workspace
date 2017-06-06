package com.revature.ers.servlets;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.revature.ers.servlets.LoginServlet.authenticateEmployee;

public class EmployeeHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticateEmployee(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        List<ReimbursementRequest> allRequests = user.getRequests();
        List<ReimbursementRequest> pendingRequests = new ArrayList<>();
        List<ReimbursementRequest> resolvedRequests = new ArrayList<>();

        for (ReimbursementRequest r : allRequests) {
            if (r.getState() == ReimbursementRequest.StateType.PENDING) {
                pendingRequests.add(r);
            } else {
                resolvedRequests.add(r);
            }
        }

        request.setAttribute("user", user);
        request.setAttribute("pendingRequests", pendingRequests);
        request.setAttribute("resolvedRequests", resolvedRequests);
        request.setAttribute("currentDate", LocalDate.now());

        request.setAttribute("pageTitle", "Employee Home");
        request.getRequestDispatcher("/employeeHome.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
