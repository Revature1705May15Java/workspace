package com.ex.bank.user.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ex.bank.user.domain.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		return (User) sessionFactory.getCurrentSession()
							.createQuery("from User where username=:username")
							.setString("username", username)
							.uniqueResult();
	}

	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
