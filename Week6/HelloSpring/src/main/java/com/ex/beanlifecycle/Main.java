package com.ex.beanlifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//		AbstractApplicationContext yoSpring =
		//				new ClassPathXmlApplicationContext(
		//						new String[]{"beans.xml", "processor.xml"});
		AbstractApplicationContext yoSpring =
				new ClassPathXmlApplicationContext("master.xml");
		//FileSystemXmlApplicationContext("C:\spring\config\beans.xml");
		System.out.println(
				yoSpring.getBean("jon", ParentBean.class).getSecret()
				);
		// shutting down the IoC container
		yoSpring.close(); // fires right away
		//yoSpring.registerShutdownHook(); // waits until application stops
		Thread.sleep(10000);
	}

}
