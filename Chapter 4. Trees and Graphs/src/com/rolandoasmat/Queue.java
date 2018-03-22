package com.rolandoasmat;

/**
 * First in First out Data Structure (FIFO)
 */
public class Queue {
    Node head;
    Node tail;

    void enqueue(Node node) {
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }

    Node dequeue() {
        if (head != null) {
            Node result = head;
            head = head.next;
            return result;
        } else {
            return null;
        }
    }

    boolean isEmpty() {
        return head == null;
    }
}



