package com.rolandoasmat;

public class Main {

    public static void main(String[] args) {
        // Nodes
        Node a = new Node(34);
        Node b = new Node(48);
        Node c = new Node(6);
        Node d = new Node(2);
        Node e = new Node(25);
        Node f = new Node(89);
        Node g = new Node(45);

        // Edges
        a.neighbors = new Node[]{c, e, g};
        b.neighbors = new Node[]{e, f};
        c.neighbors = new Node[]{a, g};
        d.neighbors = new Node[]{c, a, f};
        e.neighbors = new Node[]{a, b};
        f.neighbors = new Node[]{b, e, g};
        g.neighbors = new Node[]{a, b, c};

        // Graph
        Graph graph = new Graph();
        graph.nodes = new Node[]{a, b, c, d, e, f, g};

        System.out.println("Breadth First Search");
        graph.breadthFirstSearch();

        System.out.println("Depth First Search");
        graph.depthFirstSearch();
    }
}
