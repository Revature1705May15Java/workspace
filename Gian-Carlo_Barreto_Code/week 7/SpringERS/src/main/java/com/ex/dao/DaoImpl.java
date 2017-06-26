package com.ex.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Employee;
import com.ex.beans.Request;

public class DaoImpl {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Employee getEmployee(String email, String password) {
		Session s = sessionFactory.getCurrentSession();
		Employee e = new Employee();
		String hql = "FROM Employee WHERE email = :e AND password = :p";
		Query query = s.createQuery(hql);
		query.setParameter("e", email);
		query.setParameter("p", password);
		e = (Employee) query.list().get(0);
		return e;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public boolean createEmployee(Employee e) {
		Session s = sessionFactory.getCurrentSession();
		try {
			System.out.println(e);
			s.save(e);
			return true;
		}
		catch (HibernateException he) {
			he.printStackTrace();
			return false;
		}
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public boolean createRequest(Request r) {
		Session s = sessionFactory.getCurrentSession();
		try {
			s.save(r);
			return true;
		}
		catch (HibernateException he) {
			he.printStackTrace();
			return false;
		}
	} 
}
