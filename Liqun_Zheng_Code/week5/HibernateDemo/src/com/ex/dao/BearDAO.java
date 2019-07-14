package com.ex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.util.ConnectionUtil;

public class BearDAO {
	public void createBear(Bear b, HoneyPot hp, Cave c){
		Session session = ConnectionUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		b.setDwelling(c);
		b.setHoneyPot(hp);
		int hp_id = (Integer) session.save(b.getHoneyPot());
		System.out.println("Generated honey pot " + hp_id);
		
		session.save(b);
		tx.commit();
		session.close();
		
	}
	
	public Bear getOrLoad(int id) {
		Session session = ConnectionUtil.getSession();
		
//		Bear bearGet = (Bear) session.get(Bear.class, id);
//		System.out.println(bearGet.getClass() + " : getBear");
		
		Bear bearLoad = (Bear) session.load(Bear.class, id);
		System.out.println(bearLoad.getClass() + " : loadBear");
		//Bear bearLoad = (Bear) session.load (Bear.class, id);
		return bearLoad;
	
	}
}
