package com.nearsoft.javaschool.reflection.letsrock.test;

import com.nearsoft.javaschool.domain.Person;
import com.nearsoft.javaschool.database.DatabaseActions;
import com.nearsoft.javaschool.database.PersonDatabaseActions;
import com.nearsoft.javaschool.reflection.letsrock.myframework.dependencyinjection.Inject;
import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.AfterAll;
import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.AfterMethod;
import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.BeforeAll;
import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.BeforeMethod;
import com.nearsoft.javaschool.reflection.letsrock.myframework.utest.Test;

/**
 * Created by ycaceres on 10/4/17.
 */
public class DatabaseTest {

    @Inject(PersonDatabaseActions.class)
    private DatabaseActions databaseActions;

    private Person person;

    @BeforeAll
    public void initialize() {
        System.out.println("TEST >> This runs before everything.");
        this.person = new Person("John", "Doe", 30, true);
    }

    @AfterAll
    public void finish() {
        System.out.println("TEST >> This runs after everything.");
        this.person = null;
    }

    @BeforeMethod
    public void justAMethod() {
        System.out.println("TEST >> This runs before every method.");
    }

    @AfterMethod
    public void another() {
        System.out.println("TEST >> This runs after every method.");
    }

    @Test
    public void testDatabaseSave() throws InterruptedException {
        databaseActions.save(this.person);
        assertIfNotContains();
    }

    @Test
    public void testDatabaseDelete() throws InterruptedException {
        databaseActions.save(this.person);
        databaseActions.delete(this.person);
        assertIfContains();
    }

    private void assertIfContains() {
        boolean contains = databaseActions.getAll().contains(this.person);
        assert !contains;
    }

    private void assertIfNotContains() {
        boolean contains = databaseActions.getAll().contains(this.person);
        assert contains;
    }

}
