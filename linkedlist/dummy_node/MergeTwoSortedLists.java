package linkedList.dummy_node;

import java.util.*;

/*
Problem - Merge Two Sorted Lists

Brute Approach - Store Elements In ArrayList, Sort And Create New List
T.C            - O((n + m) log(n + m))
S.C            - O(n + m)

Optimal Approach - Dummy Node + Two Pointers
T.C              - O(n + m)
S.C              - O(1)
*/

public class MergeTwoSortedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        ListNode list1 = null;
        ListNode tail1 = null;

        for (int i = 0; i < n1; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (list1 == null) {
                list1 = tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        int n2 = sc.nextInt();

        ListNode list2 = null;
        ListNode tail2 = null;

        for (int i = 0; i < n2; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (list2 == null) {
                list2 = tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        // ListNode mergedHead = mergeTwoListsBrute(list1, list2);
        ListNode mergedHead = mergeTwoListsOptimal(list1, list2);

        printList(mergedHead);
        sc.close();
    }

    public static ListNode mergeTwoListsBrute(ListNode list1, ListNode list2) {

        ArrayList<Integer> list = new ArrayList<>();

        while (list1 != null) {

            list.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {

            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int value : list) {

            tail.next = new ListNode(value);
            tail = tail.next;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoListsOptimal(ListNode list1, ListNode list2) {

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