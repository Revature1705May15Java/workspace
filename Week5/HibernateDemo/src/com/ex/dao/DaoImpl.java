package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl implements DAO{
	
	/*
	 * BASIC CRUD METHODS USING HIBERNATE
	 */

	//CREATE 
	@Override
	public void createPerson(Person p) {
		
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

	//READ
	@Override
	public Person getPersonById(int id) {
		
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try{
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		
		return p;
	}
	
	//READ ALL
	public List<Person> getAllPeople(){
		/*Criteria is a simplified API for retrieving entities 
		by composing Criterion objects. This is a very 
		convenient approach for functionality like "search" screens 
		where there is a variable number of conditions to be placed 
		upon the result set.								
		*/
		

		Session session = ConnectionUtil.getSession();
		
		Criteria criteria = session.createCriteria(Person.class);
		
		List<Person> people = criteria.list();
		
		session.close();
		
		return people;
	}
	
	public void update(Person p){
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
	
	public void deleteById(int id){
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			
			session.delete(new Person(id, null,null));
			
			tx.commit();
		}finally{
			session.close();
		}

	}
	

}