package com.rolandoasmat;

public class BinaryTreeProblems {

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

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * https://leetcode.com/problems/symmetric-tree/description/
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        }
        else {
            return isSymmetric(root.left, root.right);
        }
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val == right.val) {
            return  isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }
}


