package com.rolandoasmat;

public class BinaryTreeProblems {

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
}
