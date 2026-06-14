package linkedList.in_place_rearrangement;

import java.util.*;

/*
Problem - Delete Nodes Having Greater Value on Right

Brute Approach - For Every Node Check Right Side
T.C            - O(n²)
S.C            - O(1)

Optimal Approach - Reverse + Running Maximum + Reverse
T.C              - O(n)
S.C              - O(1)
*/

public class DeleteNodesHavingGreaterValueOnRight {

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

        // head = deleteNodesBrute(head);
        head = deleteNodesOptimal(head);

        printList(head);
        sc.close();
    }

    public static Node deleteNodesBrute(Node head) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        Node current = head;

        while (current != null) {

            boolean keep = true;

            Node temp = current.next;

            while (temp != null) {

                if (temp.data > current.data) {

                    keep = false;
                    break;
                }

                temp = temp.next;
            }

            if (keep) {

                tail.next = new Node(current.data);
                tail = tail.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public static Node deleteNodesOptimal(Node head) {

        head = reverse(head);

        Node current = head;
        int maxSoFar = current.data;

        while (current != null && current.next != null) {

            if (current.next.data < maxSoFar) {

                current.next = current.next.next;

            } else {

                current = current.next;
                maxSoFar = current.data;
            }
        }

        return reverse(head);
    }

    public static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node nextNode = current.next;

            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
