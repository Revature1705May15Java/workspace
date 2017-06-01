package com.rev.servlets;

import com.rev.pojos.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fName");
        String ln = request.getParameter("lName");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("asdf");

        request.setAttribute("users", userList);
        request.getRequestDispatcher("/index.ftl").forward(request, response);
    }
}
