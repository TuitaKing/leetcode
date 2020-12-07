package com.tuitaking.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
}


// lRU 算法
class LRUMap<K,V> extends LinkedHashMap<K,V>{

    private int capacity;
    LRUMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }
    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

}