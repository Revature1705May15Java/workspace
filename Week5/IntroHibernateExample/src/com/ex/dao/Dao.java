package com.ex.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class Dao {

	public void createPerson(Person p){
		
		Session session = ConnectionUtil.getSession();

		try {
			Transaction tx = session.beginTransaction();

			session.save(p); // Create/Insert

			tx.commit();
		} finally {
			session.close();
		}

		
	}
	
	
	public Person getPersonById(int id){
		Person p = null;
		
		Session session = ConnectionUtil.getSession();

		try {
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		
		return p;
		
	}
	
}
