package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> eventClass;

    public Generator(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        T t = eventClass.newInstance();
        return t;
    }
}
