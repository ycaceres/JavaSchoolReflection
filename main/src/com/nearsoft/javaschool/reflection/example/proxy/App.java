package com.nearsoft.javaschool.reflection.example.proxy;

import com.nearsoft.javaschool.database.DatabaseActions;
import com.nearsoft.javaschool.database.PersonDatabaseActions;
import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 10/4/17.
 */
public class App {
    public static void main(String[] a) throws Exception {
        DatabaseActions databaseActions = CustomInvocationHandler.getInstance(PersonDatabaseActions.class);
        databaseActions.save(new Person());
    }
}
