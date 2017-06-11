package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.*;

public interface DAO {
	User userLogin(String em, String pw);
	ArrayList<Integer> getUserRequest(User u);
	ArrayList<Request> getUserRequests(User u);
	ArrayList<Request> getUserRequestsByStateId(User u, int id);
	String getRequestType(Request r);
	boolean makeRequest(User u, int amount, String note);
}
