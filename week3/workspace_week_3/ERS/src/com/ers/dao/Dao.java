package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojo.Request;
import com.ers.pojo.User;

public interface Dao {
	User getUser(String username);
	User getUser(int id);
	int addUser(String uname, String pw, String fn, String ln, int emp_rank);
	int addRequest(int amt, String purpose, int id);
	ArrayList<Request> getRequestsByEmployeeId(int id);
}
