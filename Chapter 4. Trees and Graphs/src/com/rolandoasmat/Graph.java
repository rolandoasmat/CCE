package com.rolandoasmat;

public class Graph {
    Node[] nodes;

    /**
     * Depth First Search
     */
    void depthFirstSearch() {
        if (nodes.length > 0) {
            dfs(nodes[0]);
        }
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        visit(node);
        node.visited = true;
        for (Node n : node.neighbors) {
            if (!n.visited) {
                dfs(n);
            }
        }
    }

    /**
     * Breadth First Search
     */
    void breadthFirstSearch() {
        if (nodes != null && nodes.length > 0) {
            bfs(nodes[0]);
        }
    }

    private void bfs(Node node) {
        Queue q = new Queue();
        q.enqueue(node);

        while (!q.isEmpty()) {
            Node n = q.dequeue();
            visit(n);
            n.visited = true;
            for (Node neighbor : n.neighbors) {
                if (!neighbor.visited) {
                    q.enqueue(neighbor);
                }
            }
        }
    }

    /**
     * Bidirectional Search
     */
    // TODO implement bidirectional

    /**
     * Helpers
     */

    private void visit(Node node) {
        System.out.println(node.data);
    }
}