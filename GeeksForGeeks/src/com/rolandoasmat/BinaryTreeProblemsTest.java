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

    @Test
    void convertToSumTree() {
        BinaryTreeProblems.Node root = new BinaryTreeProblems.Node(10);

        root.left = new BinaryTreeProblems.Node(-2);
        root.right = new BinaryTreeProblems.Node(6);

        root.left.left = new BinaryTreeProblems.Node(8);
        root.left.right = new BinaryTreeProblems.Node(-4);
        root.right.left = new BinaryTreeProblems.Node(7);
        root.right.right = new BinaryTreeProblems.Node(5);

        problems.convertToSumTree(root);

        assertEquals(20, root.data);

        assertEquals(4, root.left.data);
        assertEquals(12, root.right.data);

        assertEquals(0, root.left.left.data);
        assertEquals(0, root.left.right.data);
        assertEquals(0, root.right.left.data);
        assertEquals(0, root.right.right.data);
    }

    @Test
    void sizeOfLargestBSTSubtree() {
        BinaryTreeProblems.Node root = new BinaryTreeProblems.Node(5);

        root.left = new BinaryTreeProblems.Node(2);
        root.right = new BinaryTreeProblems.Node(4);

        root.left.left = new BinaryTreeProblems.Node(1);
        root.left.right = new BinaryTreeProblems.Node(3);

        int actual = problems.sizeOfLargestBSTSubtree(root);
        assertEquals(3, actual);

        // Another valid tree
        root = new BinaryTreeProblems.Node(50);

        root.left = new BinaryTreeProblems.Node(30);
        root.right = new BinaryTreeProblems.Node(60);

        root.left.left = new BinaryTreeProblems.Node(5);
        root.left.right = new BinaryTreeProblems.Node(20);
        root.right.left = new BinaryTreeProblems.Node(45);
        root.right.right = new BinaryTreeProblems.Node(70);

        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = null;
        root.left.right.right = null;
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = new BinaryTreeProblems.Node(65);
        root.right.right.right = new BinaryTreeProblems.Node(80);

        actual = problems.sizeOfLargestBSTSubtree(root);
        assertEquals(5, actual);
    }
}