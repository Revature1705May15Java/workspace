package com.rev.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rev.pojos.Check;
import com.rev.pojos.CreditCard;
import com.rev.pojos.Payment;

public class Main {
	public static void main(String[] args) {
		Payment payment = new Payment();
		payment.setAmount(234.12);
		
		Check check = new Check();
		check.setAmount(321.23);
		check.setCheckType("Personal");
		
		CreditCard card = new CreditCard();
		card.setAmount(3945.33);
		card.setCreditCardType("Visa");
		
		SessionFactory factory = 
				new Configuration()
				.configure()
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			Transaction tx = session.beginTransaction();
			session.save(payment);
			session.save(check);
			session.save(card);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
}
