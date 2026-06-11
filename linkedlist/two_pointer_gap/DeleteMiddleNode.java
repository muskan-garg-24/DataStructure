package linkedList.two_pointer_gap;

import java.util.*;

/*
Problem - Delete the Middle Node of a Linked List

Brute Approach - Find Length Then Delete Middle Node
T.C            - O(n)
S.C            - O(1)

Optimal Approach - Slow And Fast Pointer 
T.C              - O(n)
S.C              - O(1)
*/

public class DeleteMiddleNode {

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

        // head = deleteMiddleBrute(head);
        head = deleteMiddleOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode deleteMiddleBrute(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;
            temp = temp.next;
        }

        int middleIndex = length / 2;

        temp = head;

        for (int i = 1; i < middleIndex; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static ListNode deleteMiddleOptimal(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
} 