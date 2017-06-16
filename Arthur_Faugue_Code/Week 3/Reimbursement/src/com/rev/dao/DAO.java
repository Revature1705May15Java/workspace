package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.*;

public interface DAO {
	
	User userLogin(String em, String pw);
	ArrayList<Integer> getUserRequest(User u);
	ArrayList<Request> getUserRequests(User u);
	ArrayList<Request> getUserRequestsByStateId(User u, int id);
	String getRequestType(Request r);
	boolean makeRequest(User u, double amount, String note);
	boolean updateUser(User u, String em, String pw);
	User getUser(User u);
	ArrayList<Request> getAllRequests();
	ArrayList<String> getUserFromId(int id);
	int allRequested();
	int allResolved();
	int allPending();
	int allDenied();
	ArrayList<Request> getAllRequestsByStateId(int id);
	boolean approveRequest(int rid, int sid, int resid, String note);
	ArrayList<User> getAllEmployees();
	
}
