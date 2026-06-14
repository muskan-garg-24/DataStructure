package linkedList.in_place_rearrangement;

import java.util.*;

/*
Problem - Rotate List

Brute Approach - Rotate One Step K Times
T.C            - O(n * k)
S.C            - O(1)

Optimal Approach - Make Circular List And Break At New Tail
T.C              - O(n)
S.C              - O(1)
*/

public class RotateList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {

                head = tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        int k = sc.nextInt();

        // head = rotateRightBrute(head, k);
        head = rotateRightOptimal(head, k);

        printList(head);
        sc.close();
    }

    public static ListNode rotateRightBrute(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = getLength(head);

        k = k % length;

        while (k-- > 0) {

            ListNode prev = null;
            ListNode current = head;

            while (current.next != null) {

                prev = current;
                current = current.next;
            }

            prev.next = null;
            current.next = head;
            head = current;
        }

        return head;
    }

    public static ListNode rotateRightOptimal(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;

        ListNode tail = head;

        while (tail.next != null) {

            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int stepsToNewTail = length - k - 1;

        ListNode newTail = head;

        while (stepsToNewTail-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }

    public static int getLength(ListNode head) {

        int length = 0;

        while (head != null) {

            length++;
            head = head.next;
        }

        return length;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}