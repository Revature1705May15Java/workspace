package com.rev.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;

public class DAOImpl implements DAO {

	@Override
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

	@Override
	public Person getPersonById(int id) {
		Session session = ConnectionUtil.getSession();
		Person p = null;
		
		try {
			p = (Person) session.get(Person.class, id);
			System.out.println(p);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return p;
	}

	public List<Person> getAllPersons() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> people = criteria.list();
		session.close();
		return people;
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
	
	public void removePerson(Person p) {
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
	
	public ArrayList<Person> getPeopleLike(String regex) {
		ArrayList<Person> results = new ArrayList<Person>();
		
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class)
				.add(Restrictions.ilike("firstName", regex));
		
		results = (ArrayList<Person>) criteria.list();
		
		return results;
	}
}
