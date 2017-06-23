package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

@Transactional
public class MyDAO implements DAO {
  
  private SessionFactory sessionFactory;

  /* (non-Javadoc)
   * @see com.ex.dao.DAO#setSessionFactory(org.hibernate.SessionFactory)
   */
  @Override
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  
  /* (non-Javadoc)
   * @see com.ex.dao.DAO#getBears()
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<Bear> getBears() {
    Session s = sessionFactory.getCurrentSession();
    List<Bear> bears = new ArrayList<>();
    bears = (List<Bear>) s.createQuery("from Bear").list();
    return bears;
  }
  
  /* (non-Javadoc)
   * @see com.ex.dao.DAO#getCaves()
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<Cave> getCaves() {
    Session s = sessionFactory.getCurrentSession();
    List<Cave> caves = new ArrayList<>();
    caves = (List<Cave>) s.createQuery("from Cave").list();
    return caves; 
  }
  
  /* (non-Javadoc)
   * @see com.ex.dao.DAO#makeBear(com.ex.beans.Bear)
   */
  @Override
  @Transactional(readOnly=false, propagation=Propagation.REQUIRED)
  public void makeBear(Bear bear) {
    Session s = sessionFactory.getCurrentSession();
    s.saveOrUpdate(bear.getCave());
    s.saveOrUpdate(bear);
  }

}
