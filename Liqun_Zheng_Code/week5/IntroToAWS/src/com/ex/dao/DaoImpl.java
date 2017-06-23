package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl {

	
	public void addPerson(Person p){
		
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		finally{
			session.close();
		}
		
	}
	
	public Person getPerson(int id){
		Person p = new Person();
		
		return p;
	}
}