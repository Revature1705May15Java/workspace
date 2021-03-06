package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.pojo.HelloWorld;

///*
// * Following two important points are to be noted about the
// *  main program −
//
//The first step is to create an application context where we 
//used framework API ClassPathXmlApplicationContext(). This API
// loads beans configuration file and eventually based on the
//  provided API, it takes care of creating and initializing all
//   the objects, i.e. beans mentioned in the configuration file.
//
//The second step is used to get the required bean using
// getBean() method of the created context. This method uses
//  bean ID to return a generic object, which finally can be 
//  casted to the actual object. Once you have an object, you 
//  can use this object to call any class method.
//  
//  We also see here something called a beans.xml which is our
//  Bean Configuration file.
//  
//  [pay attention to your different types of xml files!]
//  
// *
// */
public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}

}
