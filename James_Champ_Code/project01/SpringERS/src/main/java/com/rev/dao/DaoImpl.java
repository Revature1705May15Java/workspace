package com.rev.dao;

import org.hibernate.SessionFactory;

public class DaoImpl {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
