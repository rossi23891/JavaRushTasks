package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = System.currentTimeMillis();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = System.currentTimeMillis();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long sh1Time = getTimeToGetIds(shortener1, origStrings,ids1);
        long sh2Time = getTimeToGetIds(shortener2, origStrings,ids2);
        Assert.assertTrue(sh1Time > sh2Time);
        long sh3Time = getTimeToGetStrings(shortener1, ids1,origStrings);
        long sh4Time = getTimeToGetStrings(shortener2, ids2, origStrings);
        Assert.assertEquals(sh3Time, sh4Time, 30);
    }
}
