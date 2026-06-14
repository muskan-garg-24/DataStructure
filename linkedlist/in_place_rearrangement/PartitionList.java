package linkedList.in_place_reorder;

import java.util.*;

/*
Problem - Partition List

Brute Approach - Store Less And Greater Values Separately
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Two Lists Using Dummy Nodes
T.C              - O(n)
S.C              - O(1)
*/

public class PartitionList {

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

        int x = sc.nextInt();

        // head = partitionBrute(head, x);
        head = partitionOptimal(head, x);

        printList(head);
        sc.close();
    }

    public static ListNode partitionBrute(ListNode head, int x) {

        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {
                less.add(current.val);
            } else {
                greater.add(current.val);
            }

            current = current.next;
        }

        current = head;

        for (int value : less) {

            current.val = value;
            current = current.next;
        }

        for (int value : greater) {

            current.val = value;
            current = current.next;
        }

        return head;
    }

    public static ListNode partitionOptimal(ListNode head, int x) {

        ListNode lessDummy = new ListNode(-1);
        ListNode greaterDummy = new ListNode(-1);

        ListNode lessTail = lessDummy;
        ListNode greaterTail = greaterDummy;

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {

                lessTail.next = current;
                lessTail = lessTail.next;

            } else {

                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }

            current = current.next;
        }

        greaterTail.next = null;

        lessTail.next = greaterDummy.next;

        return lessDummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}