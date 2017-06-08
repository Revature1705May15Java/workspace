package com.ex.servlets;

import com.ex.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxGetJacksonJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Person p = new Person("Chickson, Jack", 73);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        PrintWriter out = response.getWriter();
        out.write(json);
    }
}
