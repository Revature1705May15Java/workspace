package com.ex.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.util.ConnectionUtil;

public class GenericHiberDAO<E> implements GenericDAO<E> {

  @Override
  public void create(E e) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.save(e);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public E getById(int id) {
    Session session = ConnectionUtil.getSession();
    E result = null;
    try {
      result = (E) session.get(E.class, id);
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  @Override
  public ArrayList<E> getAll() {
    Session session = ConnectionUtil.getSession();
    ArrayList<E> entities = new ArrayList<>();
    try {
      
      entities = (ArrayList<E>) session.createCriteria().list();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
    return entities;
  }

  @Override
  public void update(E e) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.update(e);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void delete(E e) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.delete(e);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void deleteById(int id) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      
      session.delete();
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace();
    } finally {
      session.close();
    }
  }
  
  private Type getType() {
    
  }
  
}
