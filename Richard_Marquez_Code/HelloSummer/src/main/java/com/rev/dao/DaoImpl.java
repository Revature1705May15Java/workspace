package com.rev.dao;

import com.rev.beans.Bear;
import com.rev.beans.Cave;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DaoImpl implements Dao {
    private SessionFactory sessionFactory;

    public DaoImpl() {}

    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Bear> getBears() {
        Session s = sessionFactory.getCurrentSession();

//        List<Bear> bears = new ArrayList<>();
//        bears = s.createQuery("from Bear").list();
        List<Bear> bears = s.createQuery("from Bear").list();

        return bears;
    }

    @Override
    public List<Cave> getCaves() {
        Session s = sessionFactory.getCurrentSession();

//        List<Bear> bears = new ArrayList<>();
//        bears = s.createQuery("from Bear").list();
        List<Cave> caves = s.createQuery("from Cave").list();

        return caves;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void makeBear(Bear bear) {
        Session s = sessionFactory.getCurrentSession();

        s.saveOrUpdate(bear.getCave());
        s.save(bear);
    }
}
