package linkedList.recursion_in_LL;

import java.util.*;

/*
Problem - Recursive Search in a Linked List

Brute Approach - Iterative Traversal
T.C            - O(n)
S.C            - O(1)

Optimal Approach - Recursion
T.C              - O(n)
S.C              - O(n) (Recursion Stack)
*/

public class RecursiveSearchLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {

                head = tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        int key = sc.nextInt();

        // System.out.println(searchBrute(head, key));
        System.out.println(searchOptimal(head, key));
        sc.close();
    }

    public static boolean searchBrute(Node head, int key) {

        while (head != null) {

            if (head.data == key) {
                return true;
            }

            head = head.next;
        }

        return false;
    }

    public static boolean searchOptimal(Node head, int key) {

        if (head == null) {
            return false;
        }

        if (head.data == key) {
            return true;
        }

        return searchOptimal(head.next, key);
    }
}
