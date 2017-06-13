package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.RequestType;
import com.ers.pojos.Requests;

public interface DAO 
{
	
 public Employee getEmployee(String email);
 
 public int addRequest(int type, double amount, String purpose, int requster);
 
 public ArrayList<Requests> getR(int id);
 
 public RequestType getType (int i);
 
 public ArrayList<Requests> getAllR();

}
