package com.ex.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Person;
import com.ex.util.ConnectionUtil;

public class DaoImpl implements DAO{

	@Override
	public void createPerson(Person p) {
		
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

	@Override
	public Person getPersonById(int id) {
		Session session = ConnectionUtil.getSession();
		Person p = null;
		try{
			p = (Person) session.get(Person.class, id);
			System.out.println(p.toString());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return p;
	}

	@Override
	public ArrayList<Person> getAllPeople() {
		Session session = ConnectionUtil.getSession();
		ArrayList<Person> arrP = new ArrayList<Person>();
		Person p = null;
		try{
			arrP = (ArrayList<Person>) session.createCriteria(Person.class).list();
			for(Person i : arrP){
				System.out.println(i.toString());
			}
			System.out.println(p.toString());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return arrP;
	}

	@Override
	public boolean updatePerson(Person p) {
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.update(p);
			System.out.println(p.toString());
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

	@Override
	public boolean deletePerson(int id) {
		Session session = ConnectionUtil.getSession();
		try{
			Transaction tx = session.beginTransaction();
			session.delete(new Person(id, null, null));
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

}