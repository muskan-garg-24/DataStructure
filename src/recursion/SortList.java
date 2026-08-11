package recursion;

import java.util.Scanner;

public class SortList {

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        return merge(left, right);
    }

    // Merge two sorted lists recursively
    public static ListNode merge(ListNode left, ListNode right) {

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val <= right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    // Create Linked List
    public static ListNode createList(Scanner sc, int n) {

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            ListNode newNode = new ListNode(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    // Print Linked List
    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode head = createList(sc, n);

        head = sortList(head);

        printList(head);

        sc.close();
    }
}