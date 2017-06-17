package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class HiberUserDAO implements UserDAO {
  
  private static HiberUserDAO INSTANCE;
  private HiberUserDAO() {}
  public static HiberUserDAO getIstance() {
    if (HiberUserDAO.INSTANCE == null) {
      HiberUserDAO.INSTANCE = new HiberUserDAO();
    }
    return HiberUserDAO.INSTANCE;
  }

  @Override
  public void update(User user) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.saveOrUpdate(user);
    session.getTransaction().commit();
  }
  
  public static void main(String[] args) {
    User user = new User(1, "username", "userpass", null, null);
    
  }
  
}
