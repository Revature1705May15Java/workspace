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
import java.util.List;

import static com.revature.ers.servlets.LoginServlet.authenticateManager;

public class RequestArchiveServlet extends HttpServlet {
    private static final long serialVersionUID = 11L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!authenticateManager(request, response)) {
            response.sendRedirect("/Login");
            return;
        }

        List<ReimbursementRequest> reqs = Service.getInstance().getRequestArchive();
        request.setAttribute("requestArchive", reqs);

        request.setAttribute("pageTitle", "Request Archive");
        request.getRequestDispatcher("/requestArchive.ftl").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
