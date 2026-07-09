package recursion;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {

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

        ListNode first = mergeSort(lists, left, mid);
        ListNode second = mergeSort(lists, mid + 1, right);

        return merge(first, second);
    }

    public static ListNode merge(ListNode first, ListNode second) {

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.val <= second.val) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

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

        // Number of linked lists
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        // Input each linked list
        for (int i = 0; i < k; i++) {

            int n = sc.nextInt();   // Number of nodes in current list
            lists[i] = createList(sc, n);
        }

        ListNode result = mergeKLists(lists);

        printList(result);

        sc.close();
    }
}