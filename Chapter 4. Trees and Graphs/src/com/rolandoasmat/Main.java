package com.rolandoasmat;

public class Main {

    public static void main(String[] args) {
        // Nodes
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

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

        // Reset visited
        for(Node node : graph.nodes) {
            node.visited = false;
        }

        System.out.println("Depth First Search");
        graph.depthFirstSearch();
    }
}
