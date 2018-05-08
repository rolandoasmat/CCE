package com.rolandoasmat;

import java.util.ArrayList;

public class BinaryTreeProblems {

    public static void main(String[] args) {
        BinaryTreeProblems.Node root = new BinaryTreeProblems.Node(1);

        root.left = new BinaryTreeProblems.Node(2);
        root.right = new BinaryTreeProblems.Node(3);

        root.left.left = new BinaryTreeProblems.Node(4);
        root.left.right = new BinaryTreeProblems.Node(5);
        root.right.left = new BinaryTreeProblems.Node(6);
        root.right.right = new BinaryTreeProblems.Node(7);

        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = null;
        root.left.right.right = null;
        root.right.left.left = null;
        root.right.left.right = new BinaryTreeProblems.Node(8);
        root.right.right.left = null;
        root.right.right.right = new BinaryTreeProblems.Node(9);

        BinaryTreeProblems solver = new BinaryTreeProblems();
        solver.printTreeInVerticalOrder(root);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Check if a given Binary Tree is SumTree
     *
     * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
     */
    public boolean isSumTree(Node node) {
        if (node == null) {
            return true;
        } else if (node.left == null && node.right == null) {
            return true;
        } else {
            boolean isLeftSubtreeSumTree = isSumTree(node.left);
            boolean isRightSubtreeSumTree = isSumTree(node.right);
            if (isLeftSubtreeSumTree && isRightSubtreeSumTree) {
                int leftSubtreeSum = node.left == null ? 0 : node.left.data;
                int rightSubtreeSum = node.right == null ? 0 : node.right.data;
                int totalSum = leftSubtreeSum + rightSubtreeSum;
                if (!isParentOfALeaf(node)) {
                    totalSum *= 2;
                }
                return node.data == totalSum;
            }
            return false;
        }
    }
    private boolean isParentOfALeaf(Node node) {
        if (node.left != null) {
            if (isALeafNode(node.left)) {
                return true;
            }
        }
        if (node.right != null) {
            if (isALeafNode(node.right)) {
                return true;
            }
        }
        return false;
    }
    private boolean isALeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    /**
     * Convert a given tree to its Sum Tree
     *
     * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
     */
    public void convertToSumTree(Node node) {
        convertToSumTreeRecursive(node);
    }
    private int convertToSumTreeRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftSum = convertToSumTreeRecursive(node.left);
            int rightSum = convertToSumTreeRecursive(node.right);
            int total = leftSum + rightSum;
            int nodeData = node.data;
            node.data = total;
            return nodeData + total;
        }
    }

    /**
     * Find the largest BST subtree in a given Binary Tree
     *
     * https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
     */
    public int sizeOfLargestBSTSubtree(Node node) {
        return sizeOfLargestBSTSubtreeRecurse(node).maxSize;
    }
    private BSTInfo sizeOfLargestBSTSubtreeRecurse(Node node) {
        if (node == null) {
            return  new BSTInfo();
        } else if (isALeafNode(node)) {
            BSTInfo info = new BSTInfo();
            info.isBST = true;
            info.maxSize = 1;
            info.minValue = node.data;
            info.maxValue = node.data;
            return info;
        } else {
            BSTInfo leftInfo = sizeOfLargestBSTSubtreeRecurse(node.left);
            BSTInfo rightInfo = sizeOfLargestBSTSubtreeRecurse(node.right);
            BSTInfo info = new BSTInfo();
            int data = node.data;
            info.isBST = leftInfo.maxValue < data && data < rightInfo.minValue && leftInfo.isBST && rightInfo.isBST;
            if (info.isBST) {
                info.maxSize = leftInfo.maxSize + rightInfo.maxSize + 1;
            } else {
                info.maxSize = Math.max(leftInfo.maxSize, rightInfo.maxSize);
            }
            info.minValue = Math.min(Math.min(leftInfo.minValue, rightInfo.minValue), data);
            info.maxValue = Math.max(Math.max(leftInfo.maxValue, rightInfo.maxValue), data);
            return info;
        }
    }
    static class BSTInfo {
        boolean isBST = false;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int maxSize = 0;
    }

    /**
     * Given a binary tree, print it vertically.
     *
     * https://www.geeksforgeeks.org/print-binary-tree-vertical-order/
     */
    public void printTreeInVerticalOrder(Node node) {
        DoublyLinkedListNode<ArrayList<Integer>> linkedList = transformTree(node);
        printDoubleLinkedList(linkedList);
    }
    private DoublyLinkedListNode<ArrayList<Integer>> transformTree(Node node) {
        DoublyLinkedListNode<ArrayList<Integer>> linkedList = new DoublyLinkedListNode<>();
        transformTree(node, linkedList);
        return linkedList;
    }

    private void transformTree(Node node, DoublyLinkedListNode<ArrayList<Integer>> linkedListNode) {
        if (node == null) {
            return;
        }
        if (linkedListNode.data == null) {
            linkedListNode.data = new ArrayList<>();
        }

        ArrayList<Integer> list = linkedListNode.data;
        list.add(node.data);

        if (linkedListNode.previous == null) {
            DoublyLinkedListNode<ArrayList<Integer>> newPrevious = new DoublyLinkedListNode<>();
            linkedListNode.previous = newPrevious;
            newPrevious.next = linkedListNode;
        }
        transformTree(node.left, linkedListNode.previous);

        if (linkedListNode.next == null) {
            DoublyLinkedListNode<ArrayList<Integer>> newNext = new DoublyLinkedListNode<>();
            linkedListNode.next = newNext;
            newNext.previous = linkedListNode;
        }
        transformTree(node.right, linkedListNode.next);
    }

    private DoublyLinkedListNode<ArrayList<Integer>> findDoubleLinkedListHead(DoublyLinkedListNode<ArrayList<Integer>> node) {
        DoublyLinkedListNode<ArrayList<Integer>> head = node;
        while (head.previous != null) {
            head = head.previous;
        }
        return head;
    }

    private void printDoubleLinkedList(DoublyLinkedListNode<ArrayList<Integer>> linkedList) {
        DoublyLinkedListNode<ArrayList<Integer>> head = findDoubleLinkedListHead(linkedList);
        while (head != null) {
            ArrayList<Integer> list = head.data;
            if (list != null) {
                for (Integer number : list) {
                    System.out.print(number + " ");
                }
                System.out.println();
            }
            head = head.next;
        }
    }

    static class DoublyLinkedListNode<T> {
        DoublyLinkedListNode previous;
        DoublyLinkedListNode next;
        T data;
    }
}
