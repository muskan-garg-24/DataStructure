package linkedList.two_pointer_gap;

import java.util.*;

/*
Problem - Swapping Nodes in a Linked List

Brute Approach - Store Values In ArrayList And Swap
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Two Pointer Gap Pattern
T.C              - O(n)
S.C              - O(1)
*/

public class SwappingNodesInLinkedList {

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

        int k = sc.nextInt();

        // head = swapNodesBrute(head, k);
        head = swapNodesOptimal(head, k);

        printList(head);
        sc.close();
    }

    public static ListNode swapNodesBrute(ListNode head, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);
            temp = temp.next;
        }

        int firstIndex = k - 1;
        int secondIndex = list.size() - k;

        int value = list.get(firstIndex);

        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, value);

        temp = head;
        int index = 0;

        while (temp != null) {

            temp.val = list.get(index++);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode swapNodesOptimal(ListNode head, int k) {

        ListNode first = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode kthFromStart = first;

        ListNode second = head;

        while (first.next != null) {

            first = first.next;
            second = second.next;
        }

        ListNode kthFromEnd = second;

        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}