package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File[] files = new File (pathToAnimals).listFiles();
        Set<Animal> finalSet = new HashSet<>();
        for (File file : files) {
            if(file.getName().endsWith(".class")){
                MyClassLoader loader = new MyClassLoader();
                Class current = loader.findClass(file.getAbsolutePath());
                if(Animal.class.isAssignableFrom(current)){
                    for (Constructor constr : current.getConstructors()) {
                        if(constr.getParameterCount()==0 && constr.getModifiers()== Modifier.PUBLIC){
                            finalSet.add((Animal) constr.newInstance());
                        }
                    }
                }

            }

        }
    return finalSet;
    }

    public static class MyClassLoader extends ClassLoader{
        @Override
        protected Class<?> findClass(String s) throws ClassNotFoundException {
            byte[] classBytes = new byte[0];
            try {
                classBytes= Files.readAllBytes(Paths.get(s));
            } catch (IOException e) {

            }
            Class myClass = defineClass(null,classBytes,0,classBytes.length);
            return myClass;
        }
    }
}
