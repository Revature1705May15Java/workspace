package com.ex.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Bear;
import com.ex.beans.Cave;
import com.ex.dao.DAO;

public class Driver {
  public static void main(String[] args) {
    // magic happens here
    AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    DAO dao = (DAO) ac.getBean("myDao");
    Cave c = new Cave("Mah Cave");
    Bear b = new Bear("Bearry", 20, c);
    
    dao.makeBear(b);
    ac.close();
  }
}
