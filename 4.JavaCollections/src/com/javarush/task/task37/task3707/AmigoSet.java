package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;// вместо значений пихаем туда PRESENT

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max(16, (int) Math.ceil(collection.size() / .75f)));
        collection.forEach(e -> map.put(e, PRESENT));
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean add(Object o) {
        if (!map.containsKey(o)) {
            map.put((E) o, PRESENT);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() {
        AmigoSet<E> amigoSet = null;
        try {
            amigoSet = new AmigoSet<>();
            amigoSet.map = (HashMap<E, Object>) map.clone();
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }

    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        objectOutputStream.writeInt(map.keySet().size());
        for (E e : map.keySet()) {
            objectOutputStream.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int capacity = objectInputStream.readInt();
        float loadFactor = objectInputStream.readFloat();
        int size = objectInputStream.readInt();
        map = new HashMap<>(capacity,loadFactor);
        for (int i = 0; i <size ; i++) {
            map.put((E) objectInputStream.readObject(),PRESENT);
        }

    }
}
