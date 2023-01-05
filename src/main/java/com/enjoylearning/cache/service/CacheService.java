package com.enjoylearning.cache.service;

public interface CacheService {
    //从缓存里面拿数据
    <T> T cacheResult(String key);
    //在缓存里面存数据
    <T> void cachePut(String key,T t);
    // 从缓存里面删数据
    void cacheRemove(String key);
}
