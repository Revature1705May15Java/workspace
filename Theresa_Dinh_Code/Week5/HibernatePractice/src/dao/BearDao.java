package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Bear;
import pojos.Cave;
import pojos.HoneyPot;
import util.ConnectionUtil;

public class BearDao 
{
	public void createBear(Bear b, HoneyPot hp, Cave c)
	{
		Session session = ConnectionUtil.getSession(); 
		
		try
		{
			Transaction t = session.beginTransaction();
			b.setDwelling(c);
			b.setPot(hp);
			
			int hpid = (Integer)session.save(b.getPot()); 
			System.out.println("pot id" + hpid);

			session.save(b);
			t.commit();
			
//			Bear child = new Bear(); 
//			child.setHeight(2.5);
//			
//			parent.get
//			session.save(child); 
			
		}
		finally
		{
			session.close();
		}
	}
}
