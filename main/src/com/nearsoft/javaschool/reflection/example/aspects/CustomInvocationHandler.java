package com.nearsoft.javaschool.reflection.example.aspects;

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

        Method proxyObjectMethod = proxyObject.getClass().getMethod(method.getName(), method.getParameterTypes());
        if(proxyObjectMethod.isAnnotationPresent(ApplyAspect.class)){
            Class aspectClass = proxyObjectMethod.getAnnotation(ApplyAspect.class).value();
            Aspect aspectInstance = (Aspect) aspectClass.newInstance();

            Object before = aspectInstance.beforeMethodExecution(proxy, method, args);

            Object result = method.invoke(this.proxyObject, args);

            return aspectInstance.afterMethodExecution(proxy, method, args, before, result);
        }

        return method.invoke(this.proxyObject, args);
    }

}
