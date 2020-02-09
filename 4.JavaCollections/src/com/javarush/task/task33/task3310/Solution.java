package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
        //testStrategy(new FileStorageStrategy(),10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> ids = strings.stream().map(shortener::getId).collect(Collectors.toSet());
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = keys.stream().map(shortener::getString).collect(Collectors.toSet());
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        HashSet<String> testString = new HashSet<>();
        for (int i = 0; i <elementsNumber ; i++) {
            testString.add(Helper.generateRandomString());
        }
        Shortener testShorteenr = new Shortener(strategy);
        long start = new Date().getTime();
        Set<Long> testIDSet = getIds(testShorteenr,testString);
        long finish = new Date().getTime();
        long timing = finish-start;
        Helper.printMessage("time for getIds "+ timing);
        start = new Date().getTime();
        Set<String> testStringSet = getStrings(testShorteenr,testIDSet);
        finish = new Date().getTime();
        timing = finish-start;
        Helper.printMessage("time for getStrings "+ timing);
        if(testString.equals(testStringSet)){
            Helper.printMessage("Тест пройден.");
        }else{
            Helper.printMessage("Тест не пройден.");
        }

    }
}
