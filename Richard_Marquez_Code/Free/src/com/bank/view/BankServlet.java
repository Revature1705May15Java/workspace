package com.bank.view;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;

//@WebServlet(name = "FreeServlet")
public class BankServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Boolean uLock = new Boolean(FALSE);

    private static Service svc = new Service();
    private static User currUser;
    private static Account currAcct;

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        super.init(config);
    }

    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        super.service(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (request.getParameter("logoutButton") != null) {
            currUser = null;
        } else if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            synchronized (uLock) {
                currUser = svc.login(username, password);
                System.out.println(currUser);
            }
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("currUser", (currUser == null) ? "" : currUser);

        if (currUser == null) {
            request.getRequestDispatcher("/login.ftl").forward(request, response);
        } else {
            request.getRequestDispatcher("/bank.ftl").forward(request, response);
        }
    }
}
