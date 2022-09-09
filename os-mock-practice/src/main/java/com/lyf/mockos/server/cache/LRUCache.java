package com.lyf.mockos.server.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * // 内存缓存，file模拟缓存
 * @author liyunfei
 */
public class LRUCache<T extends CacheItem> {
    
    T[] buffer;
    
    Map<String,T> cacheMap = new HashMap<>(8);
    
    
}
