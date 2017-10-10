package com.nearsoft.javaschool.database;

import java.util.LinkedList;
import java.util.List;

import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 10/4/17.
 */
public class PersonDatabaseActions implements DatabaseActions<Person> {

    private List<Person> persons;

    public PersonDatabaseActions() {
        persons = new LinkedList<>();
    }

    @Override
    public void save(Person object) {
        persons.add(object);
        System.out.println("DATABASE >> SAVE: " + object.toString());
    }

    @Override
    public void delete(Person object) {
        persons.remove(object);
        System.out.println("DATABASE >> DELETE: " + object.toString());
    }

    @Override
    public void update(Person object) {
        // nothing to do on this example
        System.out.println("DATABASE >> UPDATE: " + object.toString());
    }

    @Override
    public List<Person> getAll() {
        System.out.println("DATABASE >> GET ALL");
        return persons;
    }
}
