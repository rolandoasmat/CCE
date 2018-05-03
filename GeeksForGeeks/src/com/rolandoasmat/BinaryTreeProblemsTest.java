package com.rolandoasmat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeProblemsTest {
    BinaryTreeProblems problems = new BinaryTreeProblems();

    @Test
    void isSumTree() {
        BinaryTreeProblems.Node root = new BinaryTreeProblems.Node(144);

        root.left = new BinaryTreeProblems.Node(20);
        root.right = new BinaryTreeProblems.Node(52);

        root.left.left = new BinaryTreeProblems.Node(3);
        root.left.right = new BinaryTreeProblems.Node(7);
        root.right.left = new BinaryTreeProblems.Node(11);
        root.right.right = new BinaryTreeProblems.Node(15);

        root.left.left.left = new BinaryTreeProblems.Node(1);
        root.left.left.right = new BinaryTreeProblems.Node(2);
        root.left.right.left = new BinaryTreeProblems.Node(3);
        root.left.right.right = new BinaryTreeProblems.Node(4);
        root.right.left.left = new BinaryTreeProblems.Node(5);
        root.right.left.right = new BinaryTreeProblems.Node(6);
        root.right.right.left = new BinaryTreeProblems.Node(7);
        root.right.right.right = new BinaryTreeProblems.Node(8);

        assertTrue(problems.isSumTree(root));

        // Another valid tree

        root = new BinaryTreeProblems.Node(26);

        root.left = new BinaryTreeProblems.Node(10);
        root.right = new BinaryTreeProblems.Node(3);

        root.left.left = new BinaryTreeProblems.Node(4);
        root.left.right = new BinaryTreeProblems.Node(6);
        root.right.left = null;
        root.right.right = new BinaryTreeProblems.Node(3);

        assertTrue(problems.isSumTree(root));
    }
}