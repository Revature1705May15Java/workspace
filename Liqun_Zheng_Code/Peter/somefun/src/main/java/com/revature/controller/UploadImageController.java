package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.UserDaoHibernate;
import com.revature.model.User;

public class UploadImageController {
	public static String uploadImage(HttpServletRequest request){
		User loggedUser = new User(1, "sdfsdf", "12344", null, null);
		
		//If this is null? Redirect the user to the login
		
		if(request.getMethod().equals("GET")){
				return "profile.jsp";
		}
		
		//WHATEVER IS HERE, IS POST
		loggedUser.setImage(request.getParameter("blob").getBytes());
		UserDaoHibernate.getUserDao().update(loggedUser);
		
		request.getSession().setAttribute("loggedUser", loggedUser);
		request.getSession().setAttribute("blob", new String(loggedUser.getImage()));
		
		return "profile.jsp";
	}
}
