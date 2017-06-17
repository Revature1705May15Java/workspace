package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.HiberUserDAO;
import com.revature.model.User;

public class UploadImageController {
  public static String uploadImage(HttpServletRequest request) {
    User loggedUser = new User(1, "username", "userpass", null, null);
    if (request.getMethod().equals("GET")) {
      return "profile.jsp";
    }
    // IF NOT "GET", USE "POST"
    loggedUser.setImage(request.getParameter("blob").getBytes());
    HiberUserDAO dao = HiberUserDAO.getIstance();
    dao.update(loggedUser);
    request.getSession().setAttribute("loggedUser", loggedUser);
    request.getSession().setAttribute("blob", new String(loggedUser.getImage()));
    return "profile.jsp";
  }
}
