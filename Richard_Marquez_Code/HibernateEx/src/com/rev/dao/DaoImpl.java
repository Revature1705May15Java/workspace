package com.rev.dao;

import com.rev.pojos.Person;
import com.rev.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return null;
    }
}
