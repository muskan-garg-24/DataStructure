package linkedList.merge_pattern;

import java.util.*;

/*
Problem - Merge Sort on Doubly Linked List

Brute Approach - Copy Elements Into Array, Sort, Rebuild DLL
T.C            - O(n log n)
S.C            - O(n)

Optimal Approach - Merge Sort (Merge Pattern + Fast & Slow Pointer)
T.C              - O(n log n)
S.C              - O(log n)
*/

public class MergeSortOnDoublyLinkedList {

    static class Node {

        int data;
        Node next;
        Node prev;

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
                newNode.prev = tail;
                tail = newNode;
            }
        }

        sc.close();

        head = mergeSort(head);

        printForward(head);
        printBackward(head);
    }

    public static Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMiddle(head);

        Node secondHead = mid.next;

        mid.next = null;
        secondHead.prev = null;

        Node left = mergeSort(head);
        Node right = mergeSort(secondHead);

        return merge(left, right);
    }

    public static Node getMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        // Fast & Slow Pointer Pattern

        while (fast.next != null &&
               fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node first, Node second) {

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (first != null && second != null) {

            if (first.data <= second.data) {

                tail.next = first;
                first.prev = tail;

                first = first.next;

            } else {

                tail.next = second;
                second.prev = tail;

                second = second.next;
            }

            tail = tail.next;
        }

        if (first != null) {

            tail.next = first;
            first.prev = tail;
        }

        if (second != null) {

            tail.next = second;
            second.prev = tail;
        }

        Node newHead = dummy.next;
        newHead.prev = null;

        return newHead;
    }

    public static void printForward(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " ");
            if (temp.next == null) break;

            temp = temp.next;
        }

        System.out.println();
    }

    public static void printBackward(Node head) {

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }
}