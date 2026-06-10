package linkedList.dummy_node;

import java.util.*;

/*
Problem - Remove Nth Node From End of List

Brute Approach - Find Length Then Delete Target Node
T.C            - O(n)
S.C            - O(1)

Optimal Approach - Dummy Node + Two Pointers
T.C              - O(n)
S.C              - O(1)
*/

public class RemoveNthNodeFromEnd {

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

        int nthNode = sc.nextInt();

        // head = removeNthFromEndBrute(head, nthNode);
        head = removeNthFromEndOptimal(head, nthNode);

        printList(head);
        sc.close();
    }

    public static ListNode removeNthFromEndBrute(ListNode head, int n) {

        int length = 0;

        ListNode temp = head;

        while (temp != null) {

            length++;
            temp = temp.next;
        }

        int position = length - n;

        if (position == 0) {
            return head.next;
        }

        temp = head;

        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static ListNode removeNthFromEndOptimal(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}