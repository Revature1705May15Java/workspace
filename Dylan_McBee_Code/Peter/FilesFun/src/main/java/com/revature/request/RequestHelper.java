package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;
import com.revature.controller.UploadImageController;

public class RequestHelper {

	public String process(HttpServletRequest request){
		switch(request.getRequestURI()){
		case "/FilesFun/revature.do":
			return LoginController.login(request);
		case "/FilesFun/profile.do":
			return UploadImageController.uploadImage(request);
			default:
					return "";
		}
		
	}
	
}
