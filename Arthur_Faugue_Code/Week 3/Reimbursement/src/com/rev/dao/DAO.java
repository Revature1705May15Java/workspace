package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.*;

public interface DAO {
	User userLogin(String em, String pw);
	ArrayList<Request> getUserRequest(User u);
	String getRequestType(Request r);
}
