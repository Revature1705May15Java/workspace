package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojo.Request;
import com.ers.pojo.User;

public interface Dao {
	boolean deleteRequest(int id);
	boolean updateRequestById(Request req);
	User getUser(String username);
	User getUser(int id);
	Request getRequestById(int id);
	int addUser(String uname, String pw, String fn, String ln, int emp_rank);
	int addRequest(double amt, String purpose, int id);
	boolean editUser(String col, String edit, User u);
	ArrayList<Request> getRequestsByEmployeeId(int id);
}
