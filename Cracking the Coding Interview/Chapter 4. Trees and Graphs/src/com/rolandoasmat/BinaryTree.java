package com.rolandoasmat;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    int sumOfLeafNodes() {
        return sumOfLeafNodes(this.root);
    }

    int sumOfLeafNodes(Node node) {
        if(node.left == null && node.right == null) {
            return node.data;
        } else {
            return sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
        }
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

    public int verticalSum(int column) {
        DoubleLinkedList list = calculateVerticalSums(root);
        DoubleLinkedList.Node n = list.head;

        while(column > 0) {
            n = n.next;
            column--;
        }
        return n.data;
    }

    private DoubleLinkedList calculateVerticalSums(BinaryTree.Node root) {
        DoubleLinkedList.Node node = new DoubleLinkedList.Node(0);
        DoubleLinkedList list = new DoubleLinkedList(node);
        getVerticalSums(list.head, root);
        // Update head of list
        while(list.head.previous != null){
            list.head = list.head.previous;
        }
        list.head = list.head.next;
        return list;
    }

    private void getVerticalSums(DoubleLinkedList.Node listNode, BinaryTree.Node treeNode) {
        if (treeNode != null) {
            listNode.data += treeNode.data;
            if(listNode.previous == null) {
                DoubleLinkedList.Node newNode = new DoubleLinkedList.Node(0);
                listNode.previous = newNode;
                newNode.next = listNode;
            }
            if(listNode.next == null) {
                DoubleLinkedList.Node newNode = new DoubleLinkedList.Node(0);
                listNode.next = newNode;
                newNode.previous = listNode;
            }
            getVerticalSums(listNode.previous, treeNode.left);
            getVerticalSums(listNode.next, treeNode.right);
        }
    }
}
