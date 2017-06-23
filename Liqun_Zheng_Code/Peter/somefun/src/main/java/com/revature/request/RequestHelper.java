package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.UploadImageController;
import com.revature.controller.loginController;

public class RequestHelper {
	public String process(HttpServletRequest request){
		switch(request.getRequestURI()){
		case"/somefun/revature.do":
			return loginController.login(request);
		case "/somefun/profile.do" :
			return UploadImageController.uploadImage(request);
		default:
			return "";
		}
	}
}
