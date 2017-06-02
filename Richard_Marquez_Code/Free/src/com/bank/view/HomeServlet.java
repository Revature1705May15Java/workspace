package com.bank.view;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service svc = new Service();
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        if (user != null) {
            ArrayList<Account> accounts = svc.getAccounts(user);

            request.setAttribute("user", user);
            request.setAttribute("accounts", accounts);

            request.getRequestDispatcher("/home.ftl").forward(request, response);
        } else {
            response.sendRedirect("/Login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
