package com.rev.servlets;


import com.rev.pojos.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet(name = "FreeServlet")
public class FreeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<User> userList = new ArrayList<>();

    static {
        userList.add(new User("asdf", "wekrj"));
        userList.add(new User("ljf", "lfkjsklfj"));
        userList.add(new User("ieoj", "fjklj"));
    }

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
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");

        if (fName != null && lName != null && !fName.isEmpty() && !lName.isEmpty()) {
            synchronized (userList) {
                userList.add(new User(fName, lName));
            }
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("asdf");

        request.setAttribute("users", userList);
        request.getRequestDispatcher("/free.ftl").forward(request, response);
    }
}

