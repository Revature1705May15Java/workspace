package com.ex.main;

import com.ex.beans.HelloWorld;
import org.springframework.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
}
