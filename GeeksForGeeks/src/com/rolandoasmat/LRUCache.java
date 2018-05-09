package com.rolandoasmat;

import java.util.HashMap;

/**
 * LRU Cache Implementation
 * How to implement LRU caching scheme? What data structures should be used?
 * We are given total possible page numbers that can be referred. We are also given cache (or memory) size
 * (Number of page frames that cache can hold at a time). The LRU caching scheme is to remove the least recently used
 * frame when the cache is full and a new page is referenced which is not there in cache.
 *
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 */
public class LRUCache {
    private static class DoubleLinkedListNode<T> {
        T value;
        DoubleLinkedListNode<T> previous;
        DoubleLinkedListNode<T> next;

        public DoubleLinkedListNode(T value) {
            this.value = value;
        }

        public void removeSelfFromLinkedList() {

        }
    }

    private static class DoubleLinkedList<T> {
        DoubleLinkedListNode<T> head;
        DoubleLinkedListNode<T> tail;

        // Adds a node to beginning of list
        public void enqueue(DoubleLinkedListNode<T> node) {

        }

        // Removes the last node
        public void dequeue() {

        }


    }

    private int size = 0;
    private int capacity;
    private HashMap<Integer, DoubleLinkedListNode<Integer>> map = new HashMap<>();
    private DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // Looks for x in the cache
    public void refer(int x) {
        if (map.containsKey(x)) {
            DoubleLinkedListNode<Integer> node = map.get(x);
            node.removeSelfFromLinkedList();
            linkedList.enqueue(node);
        } else {
            if (size + 1 < capacity) {
                DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(x);
                linkedList.enqueue(node);
                size++;
            } else {
                linkedList.dequeue();
                DoubleLinkedListNode<Integer> node = new DoubleLinkedListNode<>(x);
                linkedList.enqueue(node);
            }
        }
    }
}

