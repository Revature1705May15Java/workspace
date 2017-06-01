package com.rev.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] interests = request.getParameterValues("interests");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");

        out.println("<p>username: " + username + "</p");
        out.println("<p>password: " + password + "</p");

        out.println("<p>interests: ");
        for (String i : interests) {
            out.print(i + "  ");
        }

        out.println("<p>sex: " + sex + "</p");
        out.println("<p>country: " + country + "</p");

        out.println("<p>languages: ");
        for (String l : languages) {
            out.print(l + "  ");
        }

    }
}
