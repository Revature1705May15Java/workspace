package com.revature.controllers;

import com.revature.model.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EmployeeController {

    private EmployeeService svc = EmployeeService.getInstance();

    @RequestMapping(value = { "", "/", }, method = RequestMethod.GET)
    public String getLanding() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee e = svc.getEmployeeById(employeeId);

        return e;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {

        Employee e = svc.login(request.getParameter("email"), request.getParameter("password"));


        if(e != null) {
            request.getSession().setAttribute("employee", e);

            if (e.getIsManager() == 1) {
                return "managerHome";
            } else {
                return "employeeHome";

            }
        } else {
            return "login";

        }
    }

    @ResponseBody
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public boolean addEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean result = svc.addEmployee(
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                Integer.parseInt(request.getParameter("isManager"))
        );

        System.out.println("added empl");

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "addRequest", method = RequestMethod.POST)
    public boolean addRequest(HttpServletRequest request, HttpServletResponse response) {
        boolean result = RequestService.getInstance().addRequest(
                Double.parseDouble(request.getParameter("amount")),
                ((Employee)request.getSession().getAttribute("employee")).getId(),
                request.getParameter("purpose")
        );

        return result;
    }

}
