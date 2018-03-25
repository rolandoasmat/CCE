package com.rolandoasmat;

public class Tree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Tree(Node root) {
        this.root = root;
    }


    /**
     * Determine the level of specified Node
     * @param node The node we're looking for
     * @return level of the node
     */
    int findLevelOfNode(Node node) {
        return findLevelOfNode(node, root,0);
    }

    int findLevelOfNode(Node nodeToFind, Node current, int level) {
        if (current == null) {
            return 0;
        } else if(current.data == nodeToFind.data) {
            return level;
        } else {
            level++;
            return findLevelOfNode(nodeToFind, current.left, level) + findLevelOfNode(nodeToFind, current.right, level);
        }
    }
}
