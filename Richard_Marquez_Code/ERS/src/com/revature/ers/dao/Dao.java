package com.revature.ers.dao;

import com.revature.ers.pojos.User;

public interface Dao {
    User getUser(String email);
    User getUser(int id);
    boolean addUser(String email, String password, String fName, String lName, boolean isManager);
    User updateUser(User u);
}

