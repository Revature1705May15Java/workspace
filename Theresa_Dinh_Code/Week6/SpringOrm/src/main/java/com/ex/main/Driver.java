package com.ex.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Bear;
import com.ex.beans.Cave;
import com.ex.dao.Dao;

public class Driver 
{
	public static void main(String[] args)
	{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml"); 
		Dao dao = (Dao) ac.getBean("myDao"); 
		
		Cave c = new Cave("cave"); 
		Bear b = new Bear(20, "bear", c); 
		
		dao.makeBear(b);
		ac.close();
	}
}
