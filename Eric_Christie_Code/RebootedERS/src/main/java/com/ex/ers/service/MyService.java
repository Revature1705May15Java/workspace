package com.ex.ers.service;

import java.util.List;

import com.ex.ers.dao.DAO;
import com.ex.ers.model.ReimbursementRequest;
import com.ex.ers.model.User;

public class MyService {
  
  private DAO dao;

  public void setDao(DAO dao) {
    this.dao = dao;
  }
  
  public User auth(User u) {
    User authUser = null;
    
    return authUser;
  }
  
  public void registerUser(User u) {
    
  }
  
  public List<ReimbursementRequest> getRequests() {
    List<ReimbursementRequest> result = null;
    
    return result;
  }
  
  public void submitRequest(ReimbursementRequest r) {
    
  }
  
  public void resolveRequest(ReimbursementRequest r) {
    
  }
  
  

}
