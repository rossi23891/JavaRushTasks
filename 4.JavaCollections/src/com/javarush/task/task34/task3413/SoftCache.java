package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        return ( softReference==null ) ? null : softReference.get();
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        AnyObject anyObject = get(key);
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if ( softReference==null ) {
            return null;
        }
        softReference.clear();
        return anyObject;

        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        AnyObject anyObject = get(key);
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        if ( softReference==null ) {
            return null;
        }
        softReference.clear();
        return anyObject;

        //напишите тут ваш код
    }
}