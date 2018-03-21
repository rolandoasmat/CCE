package com.rolandoasmat;

public class Graph {
    GraphNode[] nodes;

    /**
     * Depth First Search
     */
    void depthFirstSearch() {
        if (nodes.length > 0) {
            dfs(nodes[0]);
        }
    }

    private void dfs(GraphNode node) {
        if (node == null) {
            return;
        }
        visit(node);
        node.visited = true;
        for (GraphNode n : node.neighbors) {
            if (!n.visited) {
                dfs(n);
            }
        }
    }

    /**
     * Breadth First Search
     */
    void breadthFirstSearch() {
        if (nodes.length > 0) {
            bfs(nodes[0]);
        }
    }

    private void bfs(GraphNode node) {
        Queue q = new Queue();
        q.enqueue(node);

        while (!q.isEmpty()) {
            GraphNode n = q.dequeue();
            visit(n);
            n.visited = true;

            for (GraphNode graphNode : n.neighbors) {
                if (!graphNode.visited) {
                    q.enqueue(graphNode);
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

    private void visit(GraphNode node) {
        System.out.println(node.data);
    }

}

class GraphNode extends QueueNode {
    int data;
    boolean visited;
    GraphNode[] neighbors;
}
