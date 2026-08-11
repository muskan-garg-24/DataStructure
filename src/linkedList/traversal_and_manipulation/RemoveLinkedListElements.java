package linkedList.traversal_and_manipulation;

import java.util.*;

/*
Problem - Remove Linked List Elements (LC 203)

Brute Approach - Create New Linked List
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Basic Traversal + Dummy Node
T.C              - O(n)
S.C              - O(1)
*/

public class RemoveLinkedListElements {

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

        int target = sc.nextInt();

        // head = removeElementsBrute(head, target);
        head = removeElementsOptimal(head, target);

        printList(head);
        sc.close();
    }

    public static ListNode removeElementsBrute(ListNode head, int target) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode current = head;

        while (current != null) {

            if (current.val != target) {

                tail.next = new ListNode(current.val);
                tail = tail.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode removeElementsOptimal(ListNode head, int target) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode previous = dummy;
        ListNode current = head;

        while (current != null) {

            if (current.val == target) {

                previous.next = current.next;

            } else {

                previous = current;
            }

            current = current.next;
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
