package com.rolandoasmat;

public class Main {

    public static void main(String[] args) {
        runTree();
    }

    public static void runGraph() {
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

        System.out.println("Depth First Search");
        graph.depthFirstSearch();
    }

    public static void runTree() {
        Tree.Node one = new Tree.Node(1);
        Tree.Node two = new Tree.Node(2);
        Tree.Node three = new Tree.Node(3);
        Tree.Node four = new Tree.Node(4);
        Tree.Node five = new Tree.Node(5);
        Tree.Node six = new Tree.Node(6);
        Tree.Node seven = new Tree.Node(7);
        Tree.Node eight = new Tree.Node(8);
        Tree.Node nine = new Tree.Node(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;

        Tree tree = new Tree(one);
        Tree.Node nodeToFind = one;
        int level = tree.findLevelOfNode(nodeToFind);
        System.out.println("Level of Node: "+ nodeToFind.data+" is " +level);

    }
}
