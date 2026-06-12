package linkedList.merge_pattern;

import java.util.*;

/*
Problem - Merge K Sorted Lists

Brute Approach - Merge Lists One By One
T.C            - O(N * K)
S.C            - O(1)

Optimal Approach - Divide And Conquer + Merge Two Sorted Lists
T.C              - O(N log K)
S.C              - O(log K)
*/

public class MergeKSortedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {

            int n = sc.nextInt();

            ListNode head = null;
            ListNode tail = null;

            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                ListNode newNode = new ListNode(value);

                if (head == null) {

                    head = tail = newNode;

                } else {

                    tail.next = newNode;
                    tail = newNode;
                }
            }

            lists[i] = head;
        }

        // ListNode result = mergeKListsBrute(lists);
        ListNode result = mergeKListsOptimal(lists);

        printList(result);
        sc.close();
    }

    public static ListNode mergeKListsBrute(ListNode[] lists) {

        ListNode result = null;

        for (ListNode head : lists) {
            result = mergeTwoLists(result, head);
        }

        return result;
    }

    public static ListNode mergeKListsOptimal(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length - 1);
    }

    public static ListNode mergeSort(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode firstHalf = mergeSort(lists, left, mid);

        ListNode secondHalf = mergeSort(lists, mid + 1, right);

        return mergeTwoLists(firstHalf, secondHalf);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                tail.next = list1;
                list1 = list1.next;

            } else {

                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
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