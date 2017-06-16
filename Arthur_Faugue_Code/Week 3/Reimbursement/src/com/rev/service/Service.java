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
	
	public boolean makeRequest(User u, double amount, String note){
		return dao.makeRequest(u, amount, note);
	}
	
	public boolean updateUser(User u, String fname, String pw){
		return dao.updateUser(u, fname, pw);
	}
	
	public User getUser(User u){
		return dao.getUser(u);
	}
	
	public ArrayList<Request> getAllRequests(){
		return dao.getAllRequests();
	}
	
	public ArrayList<String> getUserFromId(int id){
		return dao.getUserFromId(id);
	}
	
	public int allRequested(){
		return dao.allRequested();
	}
	
	public int allResolved(){
		return dao.allResolved();
	}
	
	public int allPending(){
		return dao.allPending();
	}
	
	public int allDenied(){
		return dao.allDenied();
	}
	
	public ArrayList<Request> getAllRequestsByStateId(int id){
		return dao.getAllRequestsByStateId(id);
	}
	
	public boolean approveRequest(int rid, int sid, int resid, String note){
		return dao.approveRequest(rid, sid, resid, note);
	}
	public ArrayList<User> getAllEmployees(){
		return dao.getAllEmployees();
	}
}
