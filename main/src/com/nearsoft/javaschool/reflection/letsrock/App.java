package com.nearsoft.javaschool.reflection.letsrock;

import java.lang.reflect.InvocationTargetException;

import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.TestRunner;
import com.nearsoft.javaschool.reflection.letsrock.test.DatabaseTest;

/**
 * Created by ycaceres on 10/4/17.
 */
public class App {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        TestRunner.run(DatabaseTest.class);
    }
}
