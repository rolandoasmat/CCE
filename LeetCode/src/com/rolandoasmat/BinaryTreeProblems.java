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

    /**
     * Path Sum
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
     * that adding up all the values along the path equals the given sum.
     *
     * https://leetcode.com/problems/path-sum/description/
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return  false;
        } else if (root.left == null && root.right == null) {
            return sum == root.val;
        } else {
            int val = sum - root.val;
            return hasPathSum(root.left, val) || hasPathSum(root.right, val);
        }
    }

    /**
     * Count Univalue Subtrees
     * Given a binary tree, count the number of uni-value subtrees.
     * A Uni-value subtree means all nodes of the subtree have the same value.
     *
     * https://leetcode.com/problems/count-univalue-subtrees/description/
     */
    public int countUnivalSubtrees(TreeNode root) {
        Count count = new Count();
        isUni(root, count);
        return count.count;
    }
    class Count {
        int count = 0;
    }
    public boolean isUni(TreeNode root, Count count) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            count.count += 1;
            return true;
        } else {
            boolean isLeftSubtreeUni = isUni(root.left, count);
            boolean isRightSubtreeUni = isUni(root.right, count);
            if (isLeftSubtreeUni && isRightSubtreeUni) {
                if (root.left != null && root.right != null) {
                    if (root.left.val == root.val && root.right.val == root.val) {
                        count.count += 1;
                        return true;
                    }
                } else if (root.left != null && root.right == null) {
                    if (root.left.val == root.val) {
                        count.count += 1;
                        return true;
                    }
                } else if (root.right != null && root.left == null) {
                    if (root.right.val == root.val) {
                        count.count += 1;
                        return true;
                    }
                }
            }
            return false;
        }
    }

}


