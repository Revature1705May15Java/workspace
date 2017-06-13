package com.rev.dao;

import com.rev.pojos.Person;

import java.util.List;

public interface Dao {

    void createPerson(Person p);
    Person getPersonById(int id);
    void updatePerson(Person p);
    void deletePersonById(int id);

    List<Person> getAllPeople();

}