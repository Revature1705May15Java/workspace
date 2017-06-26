package com.revature.controllers;

        import com.revature.model.Employee;
        import com.revature.services.RequestService;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

//@Controller
public class RequestController {

    private RequestService svc = RequestService.getInstance();


    @ResponseBody
    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    public boolean addRequest(HttpServletRequest request, HttpServletResponse response) {
        boolean result = svc.addRequest(
                Double.parseDouble(request.getParameter("amount")),
                ((Employee)request.getSession().getAttribute("employee")).getId(),
                request.getParameter("purpose")
        );

        return result;
    }


}
