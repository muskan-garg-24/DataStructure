package recursion;

import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;
    ListNode bottom;

    ListNode(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

public class FlatteningALinkedList {

    // Flatten the linked list recursively
    public static ListNode flatten(ListNode root) {

        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);

        return merge(root, root.next);
    }

    public static ListNode merge(ListNode first, ListNode second) {

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        ListNode result;

        if (first.data <= second.data) {

            result = first;
            result.bottom = merge(first.bottom, second);

        } else {

            result = second;
            result.bottom = merge(first, second.bottom);

        }

        result.next = null;

        return result;
    }

    public static ListNode createBottomList(Scanner sc, int m) {

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < m; i++) {

            ListNode newNode = new ListNode(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.bottom = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.data);

            if (head.bottom != null) {
                System.out.print(" ");
            }

            head = head.bottom;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode root = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int m = sc.nextInt();

            ListNode list = createBottomList(sc, m);

            if (root == null) {
                root = list;
                tail = list;
            } else {
                tail.next = list;
                tail = list;
            }
        }

        root = flatten(root);

        printList(root);

        sc.close();
    }
}