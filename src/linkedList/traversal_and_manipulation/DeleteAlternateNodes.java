package linkedList.traversal_and_manipulation;

import java.util.*;

/*
Problem - Delete Alternate Nodes of a Linked List

Brute Approach - Create New Linked List
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Basic Traversal and Pointer Manipulation
T.C              - O(n)
S.C              - O(1)
*/

public class DeleteAlternateNodes {

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

        // head = deleteAlternateBrute(head);
        head = deleteAlternateOptimal(head);

        printList(head);
        sc.close();
    }

    public static Node deleteAlternateBrute(Node head) {

        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        Node current = head;

        boolean keep = true;

        while (current != null) {

            if (keep) {

                tail.next = new Node(current.data);
                tail = tail.next;
            }

            keep = !keep;

            current = current.next;
        }

        return dummy.next;
    }

    public static Node deleteAlternateOptimal(Node head) {

        Node current = head;

        while (current != null && current.next != null) {

            current.next = current.next.next;

            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }
    }
}
