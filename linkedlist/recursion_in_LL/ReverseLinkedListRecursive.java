package linkedList.recurssion_in_LL;

import java.util.*;

/*
Problem - Reverse Linked List (Recursive)

Brute Approach - Iterative Reverse
T.C            - O(n)
S.C            - O(1)

Optimal Approach - Recursion
T.C              - O(n)
S.C              - O(n) (Recursion Stack)
*/

public class ReverseLinkedListRecursive {

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

        // head = reverseBrute(head);
        head = reverseOptimal(head);

        printList(head);
        sc.close();
    }

    public static Node reverseBrute(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        return previous;
    }

    public static Node reverseOptimal(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseOptimal(head.next);

        head.next.next = head;

        head.next = null;

        return newHead;
    }

    public static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");

            head = head.next;
        }
    }
}
