package com.rolandoasmat;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    LinkedList.Node a = new LinkedList.Node(81);
        LinkedList.Node b = new LinkedList.Node(81);
        LinkedList.Node c = new LinkedList.Node(3);
        LinkedList.Node d = new LinkedList.Node(12);
        LinkedList.Node e = new LinkedList.Node(3);
        LinkedList.Node f = new LinkedList.Node(7);
        LinkedList.Node g = new LinkedList.Node(7);
        LinkedList.Node h = new LinkedList.Node(3);
        LinkedList.Node i = new LinkedList.Node(12);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        LinkedList list = new LinkedList(a);
        int[] array = {7, 3, 81, 12};
        LinkedList sorted = sortLinkedList(list, array);
        print(sorted);
    }

    static <T> void print(T t) {
        System.out.println(t);
    }

    // Sort the linked list according to array
    static LinkedList sortLinkedList(LinkedList list, int[] array) {
        // Traverse list and count occurrences
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        LinkedList.Node n = list.root;
        while(n != null) {
            if(map.containsKey(n.data)) {
                map.put(n.data, map.get(n.data) + 1);
            } else {
                map.put(n.data, 1);
            }
            n = n.next;
        }
        // Go through array and create new list
        LinkedList.Node dummy = new LinkedList.Node(0);
        LinkedList.Node current = dummy;
        for(int key : array) {
            int count = map.get(key);
            while(count > 0) {
                current.next = new LinkedList.Node(key);
                current = current.next;
                count--;
            }
        }
        return new LinkedList(dummy.next);
    }
}