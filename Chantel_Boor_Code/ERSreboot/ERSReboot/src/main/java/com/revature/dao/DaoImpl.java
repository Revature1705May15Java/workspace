package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Employee;


//marks this class for spring so it knows it creates transactions
//and interacts with the database
@Transactional
public class DaoImpl implements Dao
{
	//varible gets set by spring through setter injection
	private SessionFactory sessionFactory;

	//setter method for sessionFactory this is needed to inject the 
	//dependency for this object
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void makeEmployee(Employee employee)
	{
		Session s = sessionFactory.getCurrentSession();
		s.save(employee);
	}
	
	
}
