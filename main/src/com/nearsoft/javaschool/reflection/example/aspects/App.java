package com.nearsoft.javaschool.reflection.example.aspects;

import com.nearsoft.javaschool.database.DatabaseActions;
import com.nearsoft.javaschool.database.PersonDatabaseActions;
import com.nearsoft.javaschool.domain.Person;

/**
 * Created by ycaceres on 10/10/17.
 */
public class App {
    public static void main(String[] x) throws InterruptedException, InstantiationException, IllegalAccessException {
        DatabaseActions databaseActions = CustomInvocationHandler.getInstance(PersonDatabaseActions.class);
        databaseActions.save(new Person());
    }
}
