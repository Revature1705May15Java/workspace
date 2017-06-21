package com.revature.dao;

import com.revature.pojos.User;
import com.revature.util.HibernateUtil;
import org.hibernate.Session;

public class UserDaoHibernate implements UserDao {
    private static UserDaoHibernate INSTANCE;

    private UserDaoHibernate() {}

    public static UserDaoHibernate getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDaoHibernate();
        }

        return INSTANCE;
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(user);

        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        User user = new User(1, "richard92m", "password", null, null);

        UserDaoHibernate.getInstance().update(user);
    }

}
