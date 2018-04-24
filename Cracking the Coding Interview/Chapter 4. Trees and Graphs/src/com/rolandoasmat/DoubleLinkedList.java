package com.rolandoasmat;

public class DoubleLinkedList {
    static class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    DoubleLinkedList(Node head) {
        this.head = head;
    }
}
