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
	
	public ArrayList<Integer> getUserRequest(User u) {
		return dao.getUserRequest(u);
	}
	
	public ArrayList<Request> getUserRequests(User u) {
		return dao.getUserRequests(u);
	}
	
	public ArrayList<Request> getUserRequestsByStateId(User u, int id){
		return dao.getUserRequestsByStateId(u, id);
	}
	
	public boolean makeRequest(User u, int amount, String note){
		return dao.makeRequest(u, amount, note);
	}
}
