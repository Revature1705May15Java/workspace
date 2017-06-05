package com.revature.ers.servlets;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 6L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service svc = Service.getInstance();
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        double amount = Double.parseDouble(request.getParameter("requestAmount"));
        String purpose = request.getParameter("requestPurpose");

        ReimbursementRequest req = svc.addRequest(user, amount, purpose);

        if (req != null) {
            response.sendRedirect("/EmployeeHome");
        } else {
            PrintWriter out = response.getWriter();
            out.println("Failed to insert new request");
            out.println(user.getLastName());
            out.println(amount);
            out.println(purpose);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
