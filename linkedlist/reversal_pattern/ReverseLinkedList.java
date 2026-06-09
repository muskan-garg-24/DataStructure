package linkedList.reversal_pattern;

import java.util.*;

/*
Problem - Reverse Linked List

Brute Approach - Store Values In ArrayList And Reverse
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Iterative Reversal
T.C              - O(n)
S.C              - O(1)
*/

public class ReverseLinkedList {

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

        // head = reverseBrute(head);
        head = reverseOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode reverseBrute(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);
            temp = temp.next;
        }

        temp = head;

        for (int i = list.size() - 1; i >= 0; i--) {

            temp.val = list.get(i);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode reverseOptimal(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}