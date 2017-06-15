package test;

import dao.BearDao;
import pojos.Bear;
import pojos.Cave;
import pojos.HoneyPot;

public class Main 
{
	public static void main(String[] args)
	{
//		Person p;
//		HibDao dao = new HibDao(); 
		
//		dao.createPerson(p);
//		p = dao.getPersonById(1);
//		System.out.println(". " + p);
		
//		System.out.println(dao.getPeople());
		
		BearDao dao = new BearDao(); 
		Bear b = new Bear(); 
		HoneyPot hp = new HoneyPot(); 
		Cave c = new Cave(); 
	}
}
