package com.nearsoft.javaschool.reflection.letsrock.myframework.dependencyinjection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.nearsoft.javaschool.reflection.example.proxy.CustomInvocationHandler;

/**
 * Created by ycaceres on 10/4/17.
 */
public class DependencyInjector {

    public static <T> T injectDependencies(T object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class objectClass = object.getClass();

        for(Field field: objectClass.getDeclaredFields()) {
            if(field.isAnnotationPresent(Inject.class)){
                inject(object, field);
            }
        }

        return object;
    }

    private static <T> void inject(T object, Field field) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class annotatedType = field.getAnnotation(Inject.class).value();
        Object toInject = CustomInvocationHandler.getInstance(annotatedType);

        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(object, field.getType().cast(toInject));
        field.setAccessible(isAccessible);
    }

}
