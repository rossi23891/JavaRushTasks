package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        return new <T> ArrayList<T>((Collection<? extends T>) Arrays.asList(elements));
    }

    public static <T> HashSet <T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet set = new HashSet<>();
        for(T object : elements) {
            set.add(object);
        }
        //напишите тут ваш код
        return set;
    }

    public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        HashMap<K, V> map = new HashMap<>();
        if(keys.size() == values.size()) {
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), values.get(i));
            }
        }else
            throw new IllegalArgumentException();
        return map;
    }
}
