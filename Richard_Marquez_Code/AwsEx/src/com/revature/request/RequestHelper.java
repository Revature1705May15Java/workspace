package com.revature.request;


import com.revature.controller.LoginController;
import com.revature.controller.UploadImageController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestHelper extends HttpServlet {
    private static final long serialVersionUID = 2L;

    public String process(HttpServletRequest request) {
        switch(request.getRequestURI()) {
            case "/revature.do":
                return LoginController.login(request);

            case "/profile.do":
                return UploadImageController.uploadImage(request);

            default:
                return "login.jsp";
        }
    }

}
