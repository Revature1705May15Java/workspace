package com.revature.ers.dao;

import com.revature.ers.pojos.ReimbursementRequest;
import com.revature.ers.pojos.User;

public interface Dao {
    boolean addUser(String email, String password, String fName, String lName, boolean isManager);
    User getUser(String email);
    User getUser(int id);
    User updateUser(User u);

    int addRequest(ReimbursementRequest req);
    ReimbursementRequest getRequest(int id);
}

