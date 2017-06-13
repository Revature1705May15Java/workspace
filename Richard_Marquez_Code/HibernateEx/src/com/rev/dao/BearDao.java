package com.rev.dao;

import com.rev.pojos.Bear;
import com.rev.pojos.Cave;
import com.rev.pojos.HoneyPot;
import com.rev.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BearDao {
    public static void main(String[] args) {
        BearDao bd = new BearDao();

        Bear b = new Bear();
        HoneyPot hp = new HoneyPot();
        Cave c = new Cave();

        bd.createBear(b, hp, c);
    }

    public void createBear(Bear b, HoneyPot hp, Cave c) {
        Session s = ConnectionUtil.getSession();
        try {
            Transaction tx = s.beginTransaction();

            b.setDwelling(c);
            b.setHoneyPot(hp);

            int hpId = (Integer) s.save(b.getHoneyPot());
            System.out.println("Gened honey pot w/ id " + hpId);

            Bear child = new Bear();
            child.setHeight(3.14);
            child.setWeight(73);
            s.save(child);


            tx.commit();
        } finally {
            s.close();
        }
    }
}
