package com.rolandoasmat;

/**
 * First in First out Data Structure (FIFO)
 */
public class Queue {
    Node head;
    Node tail;

    void enqueue(Node node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    Node dequeue() {
        if (head != null) {
            Node result = head;
            if(head == tail) {
                tail = null;
                head = null;
            } else {
                head = head.next;
            }

            return result;
        } else {
            return null;
        }
    }

    boolean isEmpty() {
        return head == null;
    }
}