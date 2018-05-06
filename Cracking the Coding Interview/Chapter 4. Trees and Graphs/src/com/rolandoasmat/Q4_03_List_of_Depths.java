package com.rolandoasmat;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4_03_List_of_Depths {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public ArrayList<LinkedList<Node>> listOfDepth(Node root) {
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        listOfDepth(root, result, 0);
        return result;
    }
    private void listOfDepth(Node root, ArrayList<LinkedList<Node>> result, int level) {
        if (root != null) {
            if (result.size() < level + 1) {
                result.add(new LinkedList<>());
            }
            LinkedList list = result.get(level);
            list.add(root);
            listOfDepth(root.left, result, level +1);
            listOfDepth(root.right, result, level +1);
        }
    }
}
