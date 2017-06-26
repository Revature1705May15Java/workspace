package com.revature.dao;

import com.revature.model.Employee;
import com.revature.model.ReimbursementRequest;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DaoImpl implements Dao {
//    private static AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
//    private SessionFactory sessionFactory;
//
//    public DaoImpl() {
//    }
//
//    public DaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public static Dao getInstance() {
//        return appContext.getBean("dao", Dao.class);
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//




    private SessionFactory sessionFactory;

    public DaoImpl() {}

    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }






    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean addEmployee(Employee e) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(e);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean addRequest(ReimbursementRequest r) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(r);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Employee getEmployeeById(int id) {
        Session s = sessionFactory.getCurrentSession();
        Employee e = null;

        try {
            e = (Employee) s.get(Employee.class, id);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }

        return e;
    }


    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Employee getEmployeeByEmail(String email) {
        Session s = sessionFactory.getCurrentSession();

        try {
            Criteria criteria = s.createCriteria(Employee.class);
            Employee e = (Employee) criteria.add(Restrictions.eq("email", email)).uniqueResult();
            return e;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
}
