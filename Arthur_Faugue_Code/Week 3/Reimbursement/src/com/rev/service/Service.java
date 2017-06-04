package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DaoImpl;
import com.rev.pojo.Request;
import com.rev.pojo.User;

public class Service {
	public static DAO dao = new DaoImpl();
	
	public User userLogin(String em, String pw) {
		return dao.userLogin(em, pw);
	}
	
	public ArrayList<Request> getUserRequest(User u) {
		return dao.getUserRequest(u);
	}
}
