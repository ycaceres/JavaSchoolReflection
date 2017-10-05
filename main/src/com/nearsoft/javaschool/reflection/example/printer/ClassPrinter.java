package com.nearsoft.javaschool.reflection.example.printer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by ycaceres on 9/30/17.
 */
public class ClassPrinter {

    public static void print(Class clazz) {

        System.out.println();
        printPackage(clazz.getPackage());

        System.out.println();
        printClass(clazz);
        System.out.println(" {");

        System.out.println();
        for (Field f : clazz.getDeclaredFields()) {
            printMember(f);
        }

        System.out.println();
        for (Constructor m : clazz.getDeclaredConstructors()) {
            printMember(m);
        }

        System.out.println();
        for (Method m : clazz.getDeclaredMethods()) {
            printMember(m);
        }

        System.out.print("}");
    }

    private static void printPackage(Package aPackage) {
        System.out.print("package ");
        System.out.print(aPackage.getName());
        System.out.println("; ");
    }

    private static void printClass(Class clazz) {
        System.out.print(Modifier.toString(clazz.getModifiers()));

        System.out.print(" class ");
        System.out.print(clazz.getSimpleName());

        String superClass = clazz.getSuperclass().getSimpleName();
        if(!superClass.equals("Object")) {
            System.out.print(" extends ");
            System.out.print(superClass);
        }

        Class[] interfaces = clazz.getInterfaces();
        if(interfaces.length > 0) {
            System.out.print(" implements " + getClassArray(interfaces));
        }

    }


    private static void printMember(Member member) {

        String modifiers = Modifier.toString(member.getModifiers());

        String type = "";
        if (member instanceof Field) {
            type = ((Field) member).getType().getSimpleName();
        } else if (member instanceof Method) {
            type = ((Method) member).getReturnType().getSimpleName();
        } else if (member instanceof Constructor) {
            type = "";
        }

        String name;
        if (member instanceof Constructor) {
            name = ((Constructor) member).getDeclaringClass().getSimpleName();
        } else {
            name = member.getName();
        }


        String args = "";
        if(member instanceof Executable)
            args = getArguments((Executable) member);


        System.out.printf("\t%s %s %s %s;\n", modifiers, type, name, args);

    }

    private static String getArguments(Executable method) {
        String params = getClassArray(method.getParameterTypes());
        return String.format("(%s)", params);
    }

    private static String getClassArray(Class[] classes) {
        String[] classNames = new String[classes.length];

        for (int i = 0; i < classes.length; i++) {
            classNames[i] = classes[i].getSimpleName();
        }

        String clazz = Arrays.toString(classNames);
        clazz = clazz.substring(1, clazz.length() - 1);

        return clazz;
    }
}
