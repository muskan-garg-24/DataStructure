package linkedList.divide_and_conquer;

import java.util.*;

/*
Problem - Flatten a Multilevel Doubly Linked List (LeetCode 430)

Brute Approach - Convert to List using DFS then rebuild DLL
T.C            - O(n)
S.C            - O(n)

Optimal Approach - DFS (Recursion) / Stack based Flattening in-place
T.C              - O(n)
S.C              - O(1) (excluding recursion stack)
*/

public class FlattenMultilevelDoublyLinkedList {

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
         NOTE:
         Input building for multilevel DLL is complex.
         Here we create a sample list manually for understanding.
        */

        // Example:
        // 1 - 2 - 3 - 4
        //         |
        //         7 - 8 - 9
        //             |
        //             10

        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        head.next = n2;
        n2.prev = head;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);

        n3.child = n7;

        n7.next = n8;
        n8.prev = n7;

        n8.next = n9;
        n9.prev = n8;

        Node n10 = new Node(10);
        n8.child = n10;

        Node result = flattenOptimal(head);

        printList(result);
    }

    public static Node flattenBrute(Node head) {

        if (head == null) return null;

        List<Node> list = new ArrayList<>();

        dfs(head, list);

        Node newHead = list.get(0);

        for (int i = 0; i < list.size(); i++) {

            Node curr = list.get(i);

            curr.prev = (i == 0) ? null : list.get(i - 1);
            curr.next = (i == list.size() - 1) ? null : list.get(i + 1);
            curr.child = null;
        }

        return newHead;
    }

    // DFS to collect nodes in preorder (next then child)
    public static void dfs(Node node, List<Node> list) {

        if (node == null) return;

        Node curr = node;

        while (curr != null) {

            list.add(curr);

            if (curr.child != null) {
                dfs(curr.child, list);
            }

            curr = curr.next;
        }
    }

    public static Node flattenOptimal(Node head) {

        if (head == null) return null;

        flattenDFS(head);

        return head;
    }

    // returns tail after flattening
    public static Node flattenDFS(Node head) {

        Node curr = head;
        Node last = head;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);

                // connect curr -> child
                curr.next = childHead;
                childHead.prev = curr;

                // connect childTail -> next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null;

                last = childTail;

                curr = childTail;
            } else {
                last = curr;
            }

            curr = curr.next;
        }

        return last;
    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.val + " ");

            temp = temp.next;
        }

        System.out.println();
    }
}