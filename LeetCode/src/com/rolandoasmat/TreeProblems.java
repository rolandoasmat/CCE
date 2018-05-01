package com.rolandoasmat;

public class TreeProblems {

    /**
     * Maximum depth of a binary tree
     *
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    public int maxDepth(TreeNode node, int maxDepth) {
        if (node == null) {
            return maxDepth;
        } else if (node.left == null && node.right == null) {
            return Math.max(1, maxDepth);
        } else {
            int left = maxDepth(node.left, maxDepth);
            int right = maxDepth(node.right, maxDepth);
            return Math.max(left, right) + 1;
        }
    }
}


