package com.ex.main;

import com.ex.dao.HiberDAO;
import com.ex.dao.DAO;
import com.ex.pojos.Person;

public class Main {
  
  public static void main(String[] args) {
    Person p = new Person("Persona", "Du");
    DAO dao = new HiberDAO();
    dao.createPerson(p);
    Person x = dao.getPersonById(1);
    System.out.println(x);
    
    System.out.println(dao.getAllPeople());
    
    dao.hqlDelete(1);
  }
  
}
