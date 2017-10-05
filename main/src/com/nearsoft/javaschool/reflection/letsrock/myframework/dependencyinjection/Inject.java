package com.nearsoft.javaschool.reflection.letsrock.myframework.dependencyinjection;

/**
 * Created by ycaceres on 10/4/17.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {
    Class value();
}
