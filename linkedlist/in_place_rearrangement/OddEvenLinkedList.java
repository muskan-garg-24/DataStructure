package linkedList.in_place_reorder;

import java.util.*;

/*
Problem - Odd Even Linked List

Brute Approach - Store Odd And Even Position Values Separately
T.C            - O(n)
S.C            - O(n)

Optimal Approach - In-Place Rearrangement Using Odd And Even Pointers
T.C              - O(n)
S.C              - O(1)
*/

public class OddEvenLinkedList {

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

        // head = oddEvenListBrute(head);
        head = oddEvenListOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode oddEvenListBrute(ListNode head) {

        if (head == null) {
            return null;
        }

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        ListNode current = head;
        int position = 1;

        while (current != null) {

            if (position % 2 == 1) {
                odd.add(current.val);
            } else {
                even.add(current.val);
            }

            current = current.next;
            position++;
        }

        current = head;

        for (int value : odd) {

            current.val = value;
            current = current.next;
        }

        for (int value : even) {

            current.val = value;
            current = current.next;
        }

        return head;
    }

    public static ListNode oddEvenListOptimal(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
