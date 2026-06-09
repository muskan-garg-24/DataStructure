package linkedList.reversal_pattern;

import java.util.*;

/*
Problem - Reverse Linked List II

Brute Approach - Copy Nodes Into ArrayList And Reverse Required Part
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Head Insertion Reversal
T.C              - O(n)
S.C              - O(1)
*/

public class ReverseLinkedListII {

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

        int left = sc.nextInt();
        int right = sc.nextInt();

        // head = reverseBetweenBrute(head, left, right);
        head = reverseBetweenOptimal(head, left, right);

        printList(head);
        sc.close();
    }

    public static ListNode reverseBetweenBrute(ListNode head, int left, int right) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);
            temp = temp.next;
        }

        int start = left - 1;
        int end = right - 1;

        while (start < end) {

            int value = list.get(start);
            list.set(start, list.get(end));
            list.set(end, value);

            start++;
            end--;
        }

        temp = head;
        int index = 0;

        while (temp != null) {

            temp.val = list.get(index++);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode reverseBetweenOptimal(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}