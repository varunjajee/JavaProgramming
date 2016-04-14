package com.muks.IntrvAlgorithms.LRUCache;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by mukthar.ahmed on 2/16/16.
 * <p>
 * What is LRU Cache:
 * - LRU cache is used to maintain a record of most recently accessed and delete "Least
 * Recently Used" item in order to put a new entry while the capacity is full
 * <p>
 * LRU cache - simply implies that the elements fall out of the list from the back which indicate that the are
 * "Lest Recently Used"
 * <p>
 * <p>
 * Concept:
 * - Maintain the most recent entries at the head of the LinkedList and move "old" items
 * towards the right of the linked list
 * <p>
 * - while "put()" OR while "get()" any item, pull the entry to the head of the LinkedList
 */
public class LRU {
    // LRU LRUNode
    class LRUNode {
        int key, value;
        LRUNode previous, next;

        public LRUNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }


    // LRU cache implementation
    HashMap<Integer, LRUNode> cache = new HashMap<>();
    LRUNode head, tail;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    /**
     * put()
     */
    public void put(int key, int val) {
        // reset its value if the key already exists
        if (cache.containsKey(key)) {
            LRUNode old = cache.get(key);

            old.value = val;

            remove(old);
            setHead(old);
        } else {
            LRUNode node = new LRUNode(key, val);
            if (cache.size() >= capacity) {
                remove(tail);
                setHead(node);
            } else {
                setHead(node);
            }

            // put the key-val pair into the map at the end.
            cache.put(key, node);
        }

    }

    /* To make the get() work */
    public int get(int key) {
        if (cache.containsKey(key)) {
            LRUNode node = cache.get(key);

            remove(node);       // remove the node from the LinkedList

            setHead(node);      // set the recent accessed node as head

            return node.value;  // return the node value

        } else {
            throw new NoSuchElementException("- Key not found.");
        }
    }


    /* Cover 3 cases for remove */
    public void remove(LRUNode node) {
        if (node.previous == null) {            // node is head
            head = node.next;
        } else if (node.next == null) {           // node is tail
            tail = node.previous;
        } else {  // node is not head
            node.previous.next = node.next;          // node is in mid of the doubly LinkedList
        }
    }

    public void setHead(LRUNode node) {
        // where linked list is empty
        if (head == null) {
            head = tail = node;

        } else {
            node.previous = null;
            node.next = head;
            head.previous = node;
            head = node;
        }

        // LinkedList is full

    }

}
