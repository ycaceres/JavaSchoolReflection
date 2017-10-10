package com.nearsoft.javaschool.reflection.example.aspects;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by ycaceres on 10/10/17.
 */
public class TimeLogger implements Aspect {

    @Override
    public Object beforeMethodExecution(Object proxy, Method method, Object[] args) {
        System.out.println("[LOGGER] Getting time before method execution");
        return new Date().getTime();
    }

    @Override
    public Object afterMethodExecution(Object proxy, Method method, Object[] args, Object before, Object result) {
        long time = new Date().getTime() - (Long)before;
        System.out.println("[LOGGER] Execution time: " + time);
        return result;
    }
}
