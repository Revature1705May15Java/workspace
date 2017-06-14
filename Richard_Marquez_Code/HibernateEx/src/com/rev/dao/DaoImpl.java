package com.rev.dao;

import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {
    @Override
    public void createPerson(Person p) {
        Session s = ConnectionUtil.getSession();

        try {
            Transaction tx = s.beginTransaction();
            s.save(p);
            tx.commit();
        } finally {
            s.close();
        }
    }

    @Override
    public Person getPersonById(int id) {
        Session s = ConnectionUtil.getSession();
        Person p = null;

        try {
            p = s.get(Person.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return p;
    }

    @Override
    public void updatePerson(Person p) {
        Session s = ConnectionUtil.getSession();

        try {
            Transaction tx = s.beginTransaction();
            s.update(p);
            tx.commit();
        } finally {
            s.close();
        }
    }

    @Override
    public void deletePersonById(int id) {
        Session s = ConnectionUtil.getSession();

        try {
            Transaction tx = s.beginTransaction();
            s.delete(new Person(id, null, null));
            tx.commit();
        } finally {
            s.close();
        }
    }

    @Override
    public List<Person> getAllPeople() {
        Session s = ConnectionUtil.getSession();
        List<Person> people = new ArrayList<>();

        try {
            people = s.createCriteria(Person.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return people;
    }
}
