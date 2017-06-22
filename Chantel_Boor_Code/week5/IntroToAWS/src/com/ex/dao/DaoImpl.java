package com.ex.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl {

	
	public void addPerson(Person p)
	{
		
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
	
	public Person getPerson(int id)
	{
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try
		{
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return p;
	}
	
	public List<Person> getAll() 
	{
		Session session = ConnectionUtil.getSession();
		Criteria c = session.createCriteria(Person.class);
		
		List<Person> people = c.list();
		
		session.close();
		
		return people;
		
	}
	
	public void updatePerson(Person p) 
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
			Transaction tx = session.beginTransaction();
			session.update(p);
			
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public void deletePerson(int id) 
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
			Transaction tx = session.beginTransaction();
			
			session.delete(new Person (id,null,null,null,null,null));
			tx.commit();
			
		}
		finally
		{
			session.close();
		}
	}
}