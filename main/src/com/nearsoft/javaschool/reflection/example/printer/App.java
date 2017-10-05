package com.nearsoft.javaschool.reflection.example.printer;

import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 10/4/17.
 */
public class App {
    public static void main(String[] a) throws Exception {
        ClassPrinter.print(Person.class);
    }
}
