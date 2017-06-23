package com.rev.main;

import com.rev.beans.Bear;
import com.rev.beans.Cave;
import com.rev.dao.Dao;
import com.rev.service.CustomerService;
import com.rev.service.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dao dao = appContext.getBean("myDao", Dao.class);

        Cave c = new Cave("My Dope cave. Squawk.");
        Bear b = new Bear("Jack Chickson", 12, c);


        dao.makeBear(b);
        System.out.println
        appContext.close();

//        HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
//        obj.getMessage();

//        CustomerService svc = new CustomerServiceImpl();


//        CustomerService svc = appContext.getBean("customerService", CustomerService.class);
//        System.out.println(svc.findAll().get(0).getFirstName());
//        System.out.println(svc.getName());
    }

}
