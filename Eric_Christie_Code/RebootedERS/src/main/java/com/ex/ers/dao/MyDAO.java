package com.ex.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.ers.model.ReimbursementRequest;
import com.ex.ers.model.User;

public class MyDAO implements DAO {
  
  private SessionFactory sessionFactory;

  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#setSessionFactory(org.hibernate.SessionFactory)
   */
  @Override
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#getAllUsers()
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<User> getAllUsers() {
    List<User> result = new ArrayList<User>();
    Session session = sessionFactory.getCurrentSession();
    result = (List<User>) session.createCriteria(User.class).list();
    return result;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#createUser(com.ex.ers.model.User)
   */
  @Override
  @Transactional(readOnly=false, propagation=Propagation.REQUIRED)
  public void createUser(User u) {
    Session session = sessionFactory.getCurrentSession();
    session.save(u);
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#getUserById(int)
   */
  @Override
  public User getUserById(int id) {
    User result = null;
    Session session = sessionFactory.getCurrentSession();
    result = (User) session.get(User.class, id);
    return result;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#updateUser(com.ex.ers.model.User)
   */
  @Override
  @Transactional(readOnly=false, propagation=Propagation.REQUIRED)
  public void updateUser(User u) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(u.getRequests());
    session.saveOrUpdate(u);
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#getAllRequests()
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<ReimbursementRequest> getAllRequests() {
    List<ReimbursementRequest> result = new ArrayList<>();
    Session session = sessionFactory.getCurrentSession();
    result = (List<ReimbursementRequest>) session.createCriteria(ReimbursementRequest.class).list();
    return result;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#getRequestsByEmployee(com.ex.ers.model.User)
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<ReimbursementRequest> getRequestsByEmployee(User e) {
    List<ReimbursementRequest> result = new ArrayList<>();
    Session session = sessionFactory.getCurrentSession();
    result = (List<ReimbursementRequest>) session.createCriteria(ReimbursementRequest.class)
        .add(Restrictions.eq("REQUESTER", e)).list();
    return result;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#createRequest(com.ex.ers.model.ReimbursementRequest)
   */
  @Override
  @Transactional(readOnly=false, propagation=Propagation.REQUIRED)
  public void createRequest(ReimbursementRequest r) {
    Session session = sessionFactory.getCurrentSession();
    session.save(r);
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#getRequestById(int)
   */
  @Override
  public ReimbursementRequest getRequestById(int id) {
    ReimbursementRequest result = null;
    Session session = sessionFactory.getCurrentSession();
    result = (ReimbursementRequest) session.get(ReimbursementRequest.class, id);
    return result;
  }
  
  /* (non-Javadoc)
   * @see com.ex.ers.dao.DAO#updateRequest(com.ex.ers.model.ReimbursementRequest)
   */
  @Override
  @Transactional(readOnly=false, propagation=Propagation.REQUIRED)
  public void updateRequest(ReimbursementRequest r) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(r);
  }

}
