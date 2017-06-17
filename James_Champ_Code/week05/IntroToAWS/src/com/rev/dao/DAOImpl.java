package com.rev.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;

public class DAOImpl {
	public void createPerson(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		finally {
			session.close();
		}		
	}
	
	public Person getPersonById(int id) {
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try {
			p = (Person) session.get(Person.class, id);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return p;
	}
	
	public void update(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			
			session.update(p);
			
			tx.commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void remove(Person p) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			session.delete(p);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
}
