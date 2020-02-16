package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache lruCache;
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache(10);
    }

    @Override
    public Object retrieve(long id) {
        if(lruCache.find(id)!=null){
            return lruCache.find(id);
        }
        Object obj = originalRetriever.retrieve(id);
        lruCache.set(id,obj);
        return obj;
    }
}
