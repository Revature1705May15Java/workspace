package com.revature.ers.servlets;

import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Boolean.FALSE;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Boolean uLock = new Boolean(FALSE);

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
        request.setAttribute("pageTitle", "Login");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            synchronized (uLock) {
                User u = Service.getInstance().login(username, password);
                if (u != null) {
                    HttpSession s = request.getSession(true);
                    s.setAttribute("user", u);
                    if (u.isManager()) {
                        response.sendRedirect("/ManagerHome");
                    } else {
                        response.sendRedirect("/EmployeeHome");
                    }
                } else {
                    request.setAttribute("errorMsg", "Your login information was incorrect. Please try again.");
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


    public static boolean authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        if (user != null) {
            result = true;
        }

        return result;
    }

    public static boolean authenticateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;

        User user = (User) request.getSession().getAttribute("user");
        if (authenticate(request, response) && !user.isManager()) {
            result = true;
        }

        return result;
    }
    public static boolean authenticateManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;

        User user = (User) request.getSession().getAttribute("user");
        if (authenticate(request, response) && user.isManager()) {
            result = true;
        }

        return result;
    }

}
