package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        boolean isModifier = false;
        if(specificModifier==Modifier.ABSTRACT &&Modifier.isAbstract(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.FINAL&&Modifier.isFinal(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.INTERFACE &&Modifier.isInterface(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.NATIVE&&Modifier.isNative(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.PRIVATE&&Modifier.isPrivate(allModifiers)){
            isModifier=true;
        }
       if(specificModifier==Modifier.PROTECTED&& Modifier.isProtected(allModifiers)){
           isModifier=true;
       }
        if(specificModifier==Modifier.PUBLIC&&Modifier.isPublic(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.STATIC&&Modifier.isStatic(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.STRICT&&Modifier.isStrict(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.SYNCHRONIZED&&Modifier.isSynchronized(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.TRANSIENT&&Modifier.isTransient(allModifiers)){
            isModifier=true;
        }
        if(specificModifier==Modifier.VOLATILE&&Modifier.isVolatile(allModifiers)){
            isModifier=true;
        }
        return isModifier;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
