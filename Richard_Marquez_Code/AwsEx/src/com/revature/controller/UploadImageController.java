package com.revature.controller;

import com.revature.dao.UserDaoHibernate;
import com.revature.pojos.User;

import javax.servlet.http.HttpServletRequest;

public class UploadImageController {

    public static String uploadImage(HttpServletRequest request) {
        User user = new User(1, "richard92m", "password", null, null);

        // user is null redirect user to login

        if (request.getMethod().equals("GET")) {
            return "profile.jsp";
        }

        // transform string into byte[]
        user.setImage(request.getParameter("blob").getBytes());
        UserDaoHibernate.getInstance().update(user);

        request.getSession().setAttribute("loggedUser", user);
        request.getSession().setAttribute("blob", new String(user.getImage()));

        return "profile.jsp";
    }
}
