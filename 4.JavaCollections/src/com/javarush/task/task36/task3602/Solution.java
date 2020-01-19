package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class<?> aClass : classes) {
            if (List.class.isAssignableFrom(aClass) && Modifier.isStatic(aClass.getModifiers()) && Modifier.isPrivate(aClass.getModifiers())) {
                try {
                    Method method = aClass.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);
                    Constructor<?> constructor = aClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    method.invoke(constructor.newInstance(), 2);

                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {}
                catch (InvocationTargetException e){
                    if (e.getCause().toString().contains("IndexOutOfBoundsException")) return aClass;
                }
            }
        }

        return null;
    }
}
