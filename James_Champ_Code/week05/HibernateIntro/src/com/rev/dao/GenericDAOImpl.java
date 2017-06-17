package com.rev.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;

public class GenericDAOImpl<T> implements GenericDAO<T> {
	private final Class<T> type;
	
	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public void create(T t) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			session.save(t);
			tx.commit();
		}
		finally {
			session.close();
		}
	}

	@Override
	public T getById(int id) {
		Session session = ConnectionUtil.getSession();
		T t = null;
		
		try {
			t = (T) session.get(type, id);
			System.out.println(t);
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return t;
	}

	@Override
	public List<T> getAll() {
		Session session = ConnectionUtil.getSession();
		Criteria criteria = session.createCriteria(Person.class);
		List<T> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public void update(T t) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			
			session.update(t);
			
			tx.commit();
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void remove(T t) {
		Session session = ConnectionUtil.getSession();
		
		try {
			Transaction tx = session.beginTransaction();
			session.delete(t);
			tx.commit();
		}
		finally {
			session.close();
		}
	
	}

}
