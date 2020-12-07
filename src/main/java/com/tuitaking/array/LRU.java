package com.tuitaking.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUMapWithMap<Integer,Integer> maps=new LRUMapWithMap<Integer,Integer>(2);
        maps.put(1,1);
        maps.put(2,2);
        maps.put(3,3);
        System.out.println("hellp");
    }
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
//这种方法比上面的方法慢10倍
class LRUMapWithMap<K,V> {
    private int capacity;
    private LinkedList<K> linkedList;
    private Map<K,V> maps;
    LRUMapWithMap(int capacity){
        this.capacity=capacity;
        maps=new HashMap<>();
        linkedList=new LinkedList<>();
    }

    public V get(K key){
        if(maps.get(key)!=null){
            linkedList.remove(key);
            linkedList.addLast(key);
            return maps.get(key);
        }
        return null;
    }

    public void put(K key,V value){
        V cur=maps.get(key);
        if(cur!=null ){
                maps.put(key,value);
                linkedList.remove(key);
                linkedList.addLast(key);

        }else {

            if(linkedList.size()>=capacity){
                maps.remove(linkedList.pollFirst());
                maps.put(key,value);
                linkedList.addLast(key);
            }else {
                maps.put(key,value);
                linkedList.addLast(key);
            }
        }
    }
}