package linkedList.two_pointer_gap;

import java.util.*;

/*
Problem - Kth from End of Linked List

Brute Approach - Find Length Then Locate Kth Node From End
T.C            - O(n)
S.C            - O(1)

Optimal Approach - Two Pointer Gap Pattern
T.C              - O(n)
S.C              - O(1)
*/

public class KthFromEndOfLinkedList {

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

        int k = sc.nextInt();
        sc.close();

        // System.out.println(getKthFromLastBrute(head, k));
        System.out.println(getKthFromLastOptimal(head, k));
    }

    public static int getKthFromLastBrute(Node head, int k) {

        int length = 0;

        Node temp = head;

        while (temp != null) {

            length++;
            temp = temp.next;
        }

        if (k > length) {
            return -1;
        }

        int targetIndex = length - k;

        temp = head;

        while (targetIndex-- > 0) {
            temp = temp.next;
        }

        return temp.data;
    }

    public static int getKthFromLastOptimal(Node head, int k) {

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {

            if (fast == null) {
                return -1;
            }

            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}