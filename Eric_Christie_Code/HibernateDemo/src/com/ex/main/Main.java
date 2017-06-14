package com.ex.main;

import com.ex.dao.HiberPersonDAO;
import com.ex.dao.PersonDAO;
import com.ex.pojos.Person;

public class Main {
  
  public static void main(String[] args) {
    Person p = new Person("Persona", "Du");
    PersonDAO dao = new HiberPersonDAO();
    dao.createPerson(p);
    Person x = dao.getPersonById(1);
    System.out.println(x);
    
    System.out.println(dao.getAllPeople());
    
    dao.hqlDelete(1);
//    Session session = ConnectionUtil.getSession();
  }

}
