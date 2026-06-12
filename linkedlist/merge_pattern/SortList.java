package linkedList.merge_pattern;

import java.util.*;

/*
Problem - Sort List

Brute Approach - Store Values, Sort And Rebuild List
T.C            - O(n log n)
S.C            - O(n)

Optimal Approach - Merge Sort On Linked List
T.C              - O(n log n)
S.C              - O(log n)
*/

public class SortList {

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

        // head = sortListBrute(head);
        head = sortListOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode sortListBrute(ListNode head) {

        ArrayList<Integer> values = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            values.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(values);

        temp = head;

        int index = 0;

        while (temp != null) {

            temp.val = values.get(index++);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode sortListOptimal(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);

        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode left = sortListOptimal(head);
        ListNode right = sortListOptimal(rightHead);

        return merge(left, right);
    }

    public static ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode list1, ListNode list2) {

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