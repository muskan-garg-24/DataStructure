package linkedList.dummy_node;

import java.util.*;

/*
Problem - Flattening a Linked List

Brute Approach - Store All Values, Sort And Rebuild Bottom List
T.C            - O(n * m log(n * m))
S.C            - O(n * m)

Optimal Approach - Merge Sort Style Flattening + Dummy Node
T.C              - O(n * m * n)
S.C              - O(n)
*/

public class FlattenLinkedList {

    static class Node {

        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        /*
            Example Structure:

            5 -> 10 -> 19 -> 28
            |    |     |     |
            7    20    22    35
            |          |     |
            8          50    40
            |                |
            30               45
        */

        Node head = new Node(5);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // head = flattenBrute(head);
        head = flattenOptimal(head);

        printBottomList(head);
    }

    public static Node flattenBrute(Node root) {

        ArrayList<Integer> list = new ArrayList<>();

        Node row = root;

        while (row != null) {

            Node col = row;

            while (col != null) {

                list.add(col.data);
                col = col.bottom;
            }

            row = row.next;
        }

        Collections.sort(list);

        Node dummy = new Node(-1);
        Node tail = dummy;

        for (int value : list) {

            tail.bottom = new Node(value);
            tail = tail.bottom;
        }

        return dummy.bottom;
    }

    public static Node flattenOptimal(Node root) {

        if (root == null || root.next == null) {
            return root;
        }

        root.next = flattenOptimal(root.next);

        root = merge(root, root.next);

        return root;
    }

    public static Node merge(Node first, Node second) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (first != null && second != null) {

            if (first.data <= second.data) {

                tail.bottom = first;
                first = first.bottom;

            } else {

                tail.bottom = second;
                second = second.bottom;
            }

            tail = tail.bottom;
        }

        if (first != null) {
            tail.bottom = first;
        }

        if (second != null) {
            tail.bottom = second;
        }

        return dummy.bottom;
    }

    public static void printBottomList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");
            head = head.bottom;
        }
    }
}