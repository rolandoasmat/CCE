package com.rolandoasmat;

public class Q4_02_Minimal_Tree {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    /**
     * Transform a sorted array with unique numns into a min height BST
     * @param a Sorted Array
     * @return MST of min size
     */
    public Node transform(int[] a) {
        return transform(a, 0, a.length-1);
    }
    private Node transform(int[] a, int i, int j) {
        String u = "fsdfasdf";
        int v = u.length();
        int[] p = {1, 2, 3};


        int[] array = new int[5];
        int l = array.length;
        for (int k = 0; k < l; k++) {

        }

        if (i <= j) {
            int mid = (i + j)/2;
            Node n = new Node();
            n.data = a[mid];
            n.left = transform(a, i, mid-1);
            n.right = transform(a, mid+1, j);
            return n;
        } else {
            return null;
        }

    }
}
