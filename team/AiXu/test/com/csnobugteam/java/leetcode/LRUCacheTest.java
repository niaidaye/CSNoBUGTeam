package com.csnobugteam.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache lruCache = new LRUCache(3);

        // Test put and get operations
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);

        assertEquals(1, lruCache.get(1)); // returns 1
        assertEquals(2, lruCache.get(2)); // returns 2
        assertEquals(3, lruCache.get(3)); // returns 3

        // Test makeRecently method
        lruCache.put(4, 4); // evicts key 1, as it was the least recently used
        assertFalse(lruCache.get(1) != -1); // returns -1 (not found)
        assertEquals(2, lruCache.get(2)); // returns 2
        assertEquals(3, lruCache.get(3)); // returns 3
        assertEquals(4, lruCache.get(4)); // returns 4

        // Test removeLeastRecently method
        lruCache.put(5, 5); // evicts key 2, as it was the least recently used
        assertFalse(lruCache.get(2) != -1); // returns -1 (not found)
        assertEquals(3, lruCache.get(3)); // returns 3
        assertEquals(4, lruCache.get(4)); // returns 4
        assertEquals(5, lruCache.get(5)); // returns 5
    }


    @Test
    public void testLRUCacheCapacityOne() {
        LRUCache lruCache = new LRUCache(1);

        lruCache.put(1, 1);
        assertEquals(1, lruCache.get(1)); // returns 1

        lruCache.put(2, 2); // evicts key 1
        assertFalse(lruCache.get(1) != -1); // returns -1 (not found)
        assertEquals(2, lruCache.get(2)); // returns 2
    }

    @Test
    public void testLRUCacheEmpty() {
        LRUCache lruCache = new LRUCache(2);

        assertFalse(lruCache.get(1) != -1); // returns -1 (not found)

        lruCache.put(1, 1);
        lruCache.put(2, 2);

        assertEquals(1, lruCache.get(1)); // returns 1
        assertEquals(2, lruCache.get(2)); // returns 2

        lruCache.put(3, 3); // evicts key 1
        assertFalse(lruCache.get(1) != -1); // returns -1 (not found)
        assertEquals(2, lruCache.get(2)); // returns 2
        assertEquals(3, lruCache.get(3)); // returns 3
    }
}