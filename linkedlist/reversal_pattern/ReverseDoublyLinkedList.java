package linkedList.reversal_pattern;

import java.util.*;

/*
Problem - Reverse a Doubly Linked List

Brute Approach - Store Values In ArrayList And Reverse
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Swap Next And Prev Pointers
T.C              - O(n)
S.C              - O(1)
*/

public class ReverseDoublyLinkedList {

    static class Node {

        int data;
        Node prev;
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
                newNode.prev = tail;
                tail = newNode;
            }
        }

        // head = reverseBrute(head);
        head = reverseOptimal(head);

        printList(head);
        sc.close();
    }

    public static Node reverseBrute(Node head) {

        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;

        while (temp != null) {

            list.add(temp.data);
            temp = temp.next;
        }

        temp = head;

        for (int i = list.size() - 1; i >= 0; i--) {

            temp.data = list.get(i);
            temp = temp.next;
        }

        return head;
    }

    public static Node reverseOptimal(Node head) {

        Node current = head;
        Node temp = null;

        while (current != null) {

            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
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