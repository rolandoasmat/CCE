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
        BinaryTree tree = createDummyTree();
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node nodeToFind = one;
        int level = tree.findLevelOfNode(nodeToFind);
        System.out.println("Level of Node: "+ nodeToFind.data+" is " +level);


        tree = createDummyTree();
        int column = 3;
        int verticalSum = tree.verticalSum(column);
        print("The vertical sum at column "+ column + " is: "+verticalSum);
    }

    static <T> void print(T t) {
        System.out.println(t);
    }

    static BinaryTree createDummyTree() {
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);
        BinaryTree.Node six = new BinaryTree.Node(6);
        BinaryTree.Node seven = new BinaryTree.Node(7);
        BinaryTree.Node eight = new BinaryTree.Node(8);
        BinaryTree.Node nine = new BinaryTree.Node(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        four.left = eight;
        four.right = nine;

        BinaryTree tree = new BinaryTree(one);
        return tree;

    }
}
