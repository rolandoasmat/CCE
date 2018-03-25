package com.rolandoasmat;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    LinkedList(Node root) {
        this.root = root;
    }
}
