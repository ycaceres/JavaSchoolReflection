package com.nearsoft.javaschool.reflection.letsrock.myframework.utest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.nearsoft.javaschool.reflection.letsrock.myframework.dependencyinjection.DependencyInjector;

/**
 * Created by ycaceres on 10/4/17.
 */
public class TestRunner {

    List<Method> beforeAllMethods;
    List<Method> afterAllMethods;
    List<Method> beforeTestMethods;
    List<Method> afterTestMethods;
    List<Method> testMethods;

    Object testObject;

    private TestRunner(Object testObject) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        this.beforeAllMethods = new LinkedList<>();
        this.afterAllMethods = new LinkedList<>();
        this.beforeTestMethods = new LinkedList<>();
        this.afterTestMethods = new LinkedList<>();
        this.testMethods = new LinkedList<>();

        this.testObject = testObject;

        DependencyInjector.injectDependencies(this.testObject);

        Method[] allMethods = testObject.getClass().getDeclaredMethods();

        for(Method method: allMethods) {

            if(method.getParameterTypes().length > 0)
                continue;

            if(method.isAnnotationPresent(BeforeAll.class))
                beforeAllMethods.add(method);
            if(method.isAnnotationPresent(AfterAll.class))
                afterAllMethods.add(method);
            if(method.isAnnotationPresent(BeforeMethod.class))
                beforeTestMethods.add(method);
            if(method.isAnnotationPresent(AfterMethod.class))
                afterTestMethods.add(method);
            if(method.isAnnotationPresent(Test.class))
                testMethods.add(method);
        }

    }

    public void run() throws InvocationTargetException, IllegalAccessException {
        int runs = 0;
        int fails = 0;

        for(Method method: beforeAllMethods) {
            method.invoke(this.testObject);
        }
        for(Method method: testMethods) {
            for(Method bMethod: beforeTestMethods) {
                bMethod.invoke(this.testObject);
            }

            try {
                runs++;
                System.out.printf("RUNNER >> Running test %d of %d.\n", runs, testMethods.size());
                method.invoke(this.testObject);
            } catch (Throwable e) {
                e.printStackTrace();
                fails++;
            }

            for(Method aMethod: afterTestMethods) {
                aMethod.invoke(this.testObject);
            }
        }
        for(Method method: afterAllMethods) {
            method.invoke(this.testObject);
        }

        System.out.printf("RUNNER >> TESTS RESULT: %d tests executed, %d fails.\n", runs, fails);
    }

    public static void run(Class testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        TestRunner runner = new TestRunner(testClass.newInstance());
        runner.run();
    }
}
