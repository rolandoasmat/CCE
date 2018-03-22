package com.rolandoasmat;

/**
 * Graph node implemented using adjacency list
 */

class Node {
    int data;
    boolean visited;
    Node[] neighbors;
    Node next;

    Node(int data) {
        this.data = data;
    }
}