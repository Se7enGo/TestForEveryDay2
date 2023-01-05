package com.enjoylearning.cache.utils;

import org.springframework.stereotype.Component;

@Component
public class RedisUtils<T> {/*

    @Resource
    private RedisTemplate<String,T> template;


    //在redis中插入某个值
    public void putDataToCache(String key,T value){
        BoundValueOperations<String ,T> bvo = template.boundValueOps(key);
        bvo.set(value);
    }

    //在redis中获取某个值
    public T getDataFromCache(String key){
        BoundValueOperations<String,T> bvo = template.boundValueOps(key);
        return bvo.get();
    }

    //
    public List<Object> getCacheList(String cacheKey){
        BoundListOperations boundListOperations = template.boundListOps(cacheKey);
        Long size = boundListOperations.size();
        return  boundListOperations.range(0,size);
    }
    //从redis 更新list 数据
    public void updateCacheList(String cacheKey,List<Object> dataList){
        BoundListOperations bound = template.boundListOps(cacheKey);
        bound.rightPushAll(dataList.toArray());
    }
    //从redis 中获取map数据
    public Map<String,Object> getCacheMap(String cacheKey){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        return bound.entries();
    }

    // 从redis 中删除缓存数据
    public void clearCache(String cacheKey){
        template.delete(cacheKey);
    }
    // 获取map中 某个键的值
    public Object getDataFromCacheMap(String cacheKey,Object key){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        return bound.get(key);
    }
    //存入一个map值
    public  void putDataToCacheMap(String cacheKey,Object key,Object value){
        BoundHashOperations bound = template.boundHashOps(cacheKey);
        bound.put(key,value);
    }
*/


}
