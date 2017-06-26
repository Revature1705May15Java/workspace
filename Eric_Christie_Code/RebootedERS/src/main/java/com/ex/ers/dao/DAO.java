package com.ex.ers.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.ers.model.ReimbursementRequest;
import com.ex.ers.model.User;

public interface DAO {

  void setSessionFactory(SessionFactory sessionFactory);

  List<User> getAllUsers();

  void createUser(User u);

  User getUserById(int id);

  void updateUser(User u);

  List<ReimbursementRequest> getAllRequests();

  List<ReimbursementRequest> getRequestsByEmployee(User e);

  void createRequest(ReimbursementRequest r);

  ReimbursementRequest getRequestById(int id);

  void updateRequest(ReimbursementRequest r);

}