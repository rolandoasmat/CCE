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

    @Override
    public String toString() {
        Node t = root;
        StringBuilder builder = new StringBuilder();
        while(t != null) {
            builder.append(t.data);
            builder.append(" => ");
            t = t.next;
        }
        return builder.toString();
    }
}
