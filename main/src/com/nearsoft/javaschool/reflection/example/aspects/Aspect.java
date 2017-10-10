package com.nearsoft.javaschool.reflection.example.aspects;

import java.lang.reflect.Method;

/**
 * Created by ycaceres on 10/10/17.
 */
public interface Aspect {

    Object beforeMethodExecution(Object proxy, Method method, Object[] args);

    Object afterMethodExecution(Object proxy, Method method, Object[] args, Object before, Object result);
}
