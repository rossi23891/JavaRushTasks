package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> value : map.values()) {
            size += value.size();
        }
        return size;
        //напишите тут ваш код
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            V val = list.get(list.size() - 1);
            if (list.size() >= repeatCount) {
                list.remove(list.get(0));
            }
            list.add(value);
            return val;
        }else{
            map.put(key, new ArrayList<>());
            map.get(key).add(value);
        }
        return null;
        //напишите тут ваш код
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            V val = list.get(0);
            list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return val;
        }
        return null;
        //напишите тут ваш код
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
        //напишите тут ваш код
    }

    @Override
    public Collection<V> values() {
        List<V> total = new ArrayList<>();
        for (List<V> value : map.values()) {
            total.addAll(value);
        }
        return total;
        //напишите тут ваш код
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}