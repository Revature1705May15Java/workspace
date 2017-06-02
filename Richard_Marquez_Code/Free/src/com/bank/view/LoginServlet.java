package com.bank.view;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;

//@WebServlet(name = "FreeServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Boolean uLock = new Boolean(FALSE);
    private static Service svc = new Service();

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {
        super.destroy();
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            synchronized (uLock) {
                User u = svc.login(username, password);
                if (u != null) {
                    HttpSession s = request.getSession(true);
                    s.setAttribute("user", u);
                    response.sendRedirect("/Home");
                } else {
                    request.setAttribute("login", "fail");
                    request.getRequestDispatcher("/login.ftl").forward(request, response);
                }
            }
        } else {
            request.getRequestDispatcher("/login.ftl").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
