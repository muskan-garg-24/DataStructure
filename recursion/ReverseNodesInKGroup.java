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

public class ReverseNodesInKGroup {

    // Function to reverse nodes in groups of k
    public static ListNode reverseKGroup(ListNode head, int k) {

        // Base Case: Empty list
        if (head == null) {
            return null;
        }

        // Check if there are at least k nodes
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If fewer than k nodes remain, do not reverse
        if (count < k) {
            return head;
        }

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;
        count = 0;

        while (count < k) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        // Recursively reverse the remaining list
        head.next = reverseKGroup(curr, k);

        // Return new head of this group
        return prev;
    }

    // Function to create linked list
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

    // Function to print linked list
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

        // Number of nodes
        int n = sc.nextInt();

        // Create linked list
        ListNode head = createList(sc, n);

        // Value of k
        int k = sc.nextInt();

        // Reverse in groups of k
        head = reverseKGroup(head, k);

        // Print updated list
        printList(head);

        sc.close();
    }
}
