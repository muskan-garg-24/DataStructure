package linkedList.dummy_node;

import java.util.*;

/*
Problem - Remove Duplicates from Sorted List II

Brute Approach - Frequency Map + Create New List
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Dummy Node + Traversal
T.C              - O(n)
S.C              - O(1)
*/

public class RemoveDuplicatesFromSortedListII {

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

        // head = deleteDuplicatesBrute(head);
        head = deleteDuplicatesOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode deleteDuplicatesBrute(ListNode head) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        ListNode temp = head;

        while (temp != null) {

            frequencyMap.put(temp.val,
                    frequencyMap.getOrDefault(temp.val, 0) + 1);

            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        temp = head;

        while (temp != null) {

            if (frequencyMap.get(temp.val) == 1) {

                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }

            temp = temp.next;
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicatesOptimal(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {

                while (head.next != null &&
                       head.val == head.next.val) {

                    head = head.next;
                }

                prev.next = head.next;

            } else {

                prev = prev.next;
            }

            head = head.next;
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