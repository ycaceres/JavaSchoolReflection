package com.nearsoft.javaschool.reflection.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ycaceres on 10/4/17.
 */
public class CustomInvocationHandler implements InvocationHandler {

    private Object proxyObject;

    private CustomInvocationHandler(Object object) {
        this.proxyObject = object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {

        Object proxyObject = tClass.newInstance();
        CustomInvocationHandler handler = new CustomInvocationHandler(proxyObject);

        return (T) Proxy.newProxyInstance(
                CustomInvocationHandler.class.getClassLoader(),
                tClass.getInterfaces(),
                handler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("HANDLER >> Calling before method...");
        Object before = before(proxy, method, args);

        System.out.println("HANDLER >> Calling method..." );
        Object result = method.invoke(this.proxyObject, args);

        System.out.println("HANDLER >> Calling after method...");
        result = after(proxy, method, args, before, result);

        return result;
    }

    private Object before(Object proxy, Method method, Object[] args) throws Throwable {
        // here we can check some business restrictions or security constraints.
        System.out.println("HANDLER >> BEFORE: Nothing to do.");
        return null;
    }

    private Object after(Object proxy, Method method, Object[] args, Object before, Object result) throws Throwable {
        // here we can modify the result of method invocation depending on what we need.
        System.out.println("HANDLER >> AFTER: Nothing to do.");
        return result;
    }

}
