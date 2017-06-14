package com.ex.main;

import com.ex.dao.DAO;
import com.ex.dao.HiberDAO;
import com.ex.pojos.Person;

public class Main {
  
  public static void main(String[] args) {
//    Person p = new Person("Persona", "Du");
    DAO dao = new HiberDAO();
//    dao.createPerson(p);
    Person p = dao.getPersonById(1);
    System.out.println(p);
    
    System.out.println(dao.getAllPeople());
    
    
    
  }

}
