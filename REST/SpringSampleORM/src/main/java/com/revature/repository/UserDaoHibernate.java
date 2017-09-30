package com.revature.repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository("userRepository")
@Transactional
public class UserDaoHibernate implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoHibernate() {}

	@Override
	public void insert(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User selectById(User user) {
		return (User) sessionFactory.getCurrentSession().get(User.class, user.getId());
	}
	
	@Override
	public User selectByUsername(User user) {
		try {
			return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
			.add(Restrictions.like("username", user.getUsername()))
			.list()
			.get(0);
		}
		catch (IndexOutOfBoundsException e) {
			return new User();
		}
	}
}
