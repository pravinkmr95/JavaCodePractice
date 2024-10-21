package CollectionsPractice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;
    LRUCache(int capacity){
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        System.out.println(lruCache);
        lruCache.put(4, "Four");
        System.out.println(lruCache);
        lruCache.get(1);
        lruCache.get(2);
        System.out.println(lruCache);;
        lruCache.put(5, "Five");
        System.out.println(lruCache);
    }
}
