package com.revature.ers.dao;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;

import java.util.List;

public interface Dao {
    boolean addUser(String email, String password, String fName, String lName, boolean isManager);
    User getUser(String email);
    User getUser(int id);
    User updateUser(User u);
    List<User> getAllUsers();

    int addRequest(ReimbursementRequest req);
    boolean updateRequest(ReimbursementRequest req);
    List<ReimbursementRequest> getAllRequests();
    ReimbursementRequest getRequest(int id);
}

