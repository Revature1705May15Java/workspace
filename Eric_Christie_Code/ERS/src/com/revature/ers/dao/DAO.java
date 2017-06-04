package com.revature.ers.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.ers.pojos.Employee;
import com.revature.ers.pojos.Request;
import com.revature.ers.pojos.RequestState;

public interface DAO {
  
  Employee addEmployee(String email, String password, String firstname, String lastname, boolean isManager);
  
  Request addRequest(Employee requester, BigDecimal amount, String purpose);
  
  Request resolveRequest(Request r, Employee resolver, boolean approved, String note);
  
  ArrayList<Employee> getAllEmployees();
  
  ArrayList<Request> getAllRequests();
  
  ArrayList<RequestState> getAllRequestStates();
  
  Employee getEmployee(int id);
  
  Employee getEmployee(String email);
  
  String getEmployeePasswordHash(String email);
  
  Request getRequest(int id);
  
  ArrayList<Request> getRequests(Employee requester, Employee resolver, RequestState state);
  
  ArrayList<Request> getRequestsByRequester(String email);
  
  ArrayList<Request> getRequestsByResolver(String email);
  
  ArrayList<Request> getRequestsByState(RequestState state);
  
  boolean checkPassword(String email, String password);
  
}
