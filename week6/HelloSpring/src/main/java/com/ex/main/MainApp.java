package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.HelloWorld;

public class MainApp {
	/**Application Context
	 * 
	 * This API will configure our beans
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
		obj.getMessage();

	}

}
