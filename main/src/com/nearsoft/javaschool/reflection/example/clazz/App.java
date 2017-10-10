package com.nearsoft.javaschool.reflection.example.clazz;

import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 10/9/17.
 */
public class App {
    public static void main(String[] args) {
        Class x = Person.class;
        Person p = new Person();
        Class y = p.getClass();
        System.out.print(x==y);
    }
}
