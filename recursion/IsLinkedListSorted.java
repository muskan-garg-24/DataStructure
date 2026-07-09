package recursion;

import java.util.Scanner;

public class IsLinkedListSorted {

    public static boolean isSorted(Node head) {

        // Base Case: Empty list or single node is always sorted
        if (head == null || head.next == null) {
            return true;
        }

        // Check if list is non-decreasing
        if (head.data <= head.next.data) {
            return checkIncreasing(head);
        }

        // Check if list is non-increasing
        if (head.data >= head.next.data) {
            return checkDecreasing(head);
        }

        return false;
    }

    // Recursively check for non-decreasing order
    public static boolean checkIncreasing(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        if (head.data > head.next.data) {
            return false;
        }

        return checkIncreasing(head.next);
    }

    // Recursively check for non-increasing order
    public static boolean checkDecreasing(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        if (head.data < head.next.data) {
            return false;
        }

        return checkDecreasing(head.next);
    }

    // Function to create linked list
    public static Node createList(Scanner sc, int n) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = createList(sc, n);

        System.out.println(isSorted(head));

        sc.close();
    }
}