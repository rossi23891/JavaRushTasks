package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();
        if(map.get(currencyCode)==null){
            map.put(currencyCode,new CurrencyManipulator(currencyCode));
        }
        return map.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
