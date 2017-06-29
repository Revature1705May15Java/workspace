package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

@Transactional
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.ex.dao.Dao#getBears()
	 */
	@Override
	public List<Bear> getBears(){
		
		Session s = sessionFactory.getCurrentSession();
		List <Bear> bears = new ArrayList<Bear>();
		bears = s.createQuery("from Bear").list();
		return bears;
	}
	
	/* (non-Javadoc)
	 * @see com.ex.dao.Dao#getCaves()
	 */
	@Override
	public List<Cave> getCaves(){
		Session s = sessionFactory.getCurrentSession();
		List <Cave> caves = new ArrayList<Cave>();
		caves = s.createQuery("FROM CAVE").list();
		return caves;
	}
	
	/* (non-Javadoc)
	 * @see com.ex.dao.Dao#makeBear(com.ex.beans.Bear)
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void makeBear(Bear bear){
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(bear.getCave());
		s.save(bear);
	}
	
}