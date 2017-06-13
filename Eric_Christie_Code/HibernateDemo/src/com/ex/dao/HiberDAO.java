package com.ex.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class HiberDAO implements DAO {

  @Override
  public void createPerson(Person p) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.save(p);
      tx.commit();
    } finally {
      session.close();
    }
  }

  @Override
  public Person getPersonById(int id) {
    Session session = ConnectionUtil.getSession();
    Person p = null;
    try {
      p = (Person) session.get(Person.class, id);
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
    return p;
  }

  @SuppressWarnings("unchecked")
  @Override
  public ArrayList<Person> getAllPeople() {
    ArrayList<Person> results = new ArrayList<>();
    Session session = ConnectionUtil.getSession();
    try {
      results = (ArrayList<Person>) session.createCriteria(Person.class).list();
    } finally {
      session.close();
    }
    return results;
  }

  @Override
  public void updatePerson(Person p) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.update(p);
      tx.commit();
    } catch (HibernateException e) {
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  @Override
  public void deletePerson(Person p) {
    Session session = ConnectionUtil.getSession();
    try {
      Transaction tx = session.beginTransaction();
      session.delete(p);
      tx.commit();
    } finally {
      session.close();
    }
  }

}
