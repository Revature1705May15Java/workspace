package com.rev.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.rev.dao.DaoImpl;

@Transactional
public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		DaoImpl dao = (DaoImpl) ac.getBean("myDao");
		ac.close();
	}
}
