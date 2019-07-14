package com.revature.dao;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoHibernate implements UserDao{
	
	private static UserDaoHibernate userDaoHibernate;
	private UserDaoHibernate(){}
	public static UserDaoHibernate getUserDao(){
		if(userDaoHibernate == null){
			userDaoHibernate = new UserDaoHibernate();
		}
		return userDaoHibernate;
	}
	
	@Override
	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();	
	}
	
	public static void main(String[] args) {
		User user = new User(1, "sdfsdf", "12344", null,null);
		UserDaoHibernate.getUserDao().update(user);
	}
	
	

}
