package com.rolandoasmat;

/**
 * First in First out Data Structure (FIFO)
 */
public class Queue {
    GraphNode head;
    GraphNode tail;

    void enqueue(GraphNode node) {
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }

    GraphNode dequeue() {
        if (head != null) {
            GraphNode result = head;
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

class QueueNode {
    int data;
    GraphNode next;
}

