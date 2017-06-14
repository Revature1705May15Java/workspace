package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Person;

public interface PersonDAO {
  
  void createPerson(Person p);
  Person getPersonById(int id);
  ArrayList<Person> getAllPeople();
  void updatePerson(Person p);
  void deletePerson(int id);
  void hqlDelete(int id);

}
