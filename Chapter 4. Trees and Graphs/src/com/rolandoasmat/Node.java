package com.rolandoasmat;

/**
 * Graph node implemented using adjacency list
 */

class Node {
    String data;
    boolean visited;
    Node[] neighbors;
    Node next;

    Node(String data) {
        this.data = data;
    }
}