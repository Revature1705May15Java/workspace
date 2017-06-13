package com.rev.dao;

import com.rev.pojos.Person;

public interface Dao {

    void createPerson(Person p);
    Person getPersonById(int id);

}
