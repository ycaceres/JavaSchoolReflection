package com.nearsoft.javaschool.reflection.example.serializer;

import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 9/30/17.
 */
public class App {

    public static void main(String[] a) throws Exception {
        Person person = new Person("John", "Doe", 30, true);
        String json = JsonSerializer.serilaize(person);
        System.out.println(json);

        Person samePerson = JsonSerializer.deserilaize(Person.class, json);
        System.out.println(samePerson);
    }
}
