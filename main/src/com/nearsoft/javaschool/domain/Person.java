package com.nearsoft.javaschool.domain;


/**
 * Created by ycaceres on 9/30/17.
 */
public class Person {
    private String name;
    private String lastName;
    private int age;
    private boolean male;

    public Person() {

    }

    public Person(String name, String lastName, int age, boolean male) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return String.format("Person %s %s is a %d years old %s.", name, lastName, age, male ? "male" : "female");
    }
}
