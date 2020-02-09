package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;


public class FunctionalTest {
    Shortener shortener;

    public void testStorage(Shortener shortener) {
        String str1 = Helper.generateRandomString();
        String str2 = Helper.generateRandomString();
        String str3 = str1;

        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);

        String rebuildStr1 = shortener.getString(id1);
        String rebuildStr2 = shortener.getString(id2);
        String rebuildStr3 = shortener.getString(id3);

        Assert.assertEquals(str1, rebuildStr1);
        Assert.assertEquals(str2, rebuildStr2);
        Assert.assertEquals(str3, rebuildStr3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

}
