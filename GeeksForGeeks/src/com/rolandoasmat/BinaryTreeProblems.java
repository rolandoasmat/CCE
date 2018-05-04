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
}
