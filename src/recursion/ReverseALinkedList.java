package recursion;

import java.util.Scanner;

public class ReverseALinkedList {

    // Recursive function to reverse the linked list
    public static Node reverseList(Node head) {

        // Base Case: Empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the remaining list
        Node newHead = reverseList(head.next);

        // Reverse the current link
        head.next.next = head;
        head.next = null;

        return newHead;
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

    // Function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);

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
        Node head = createList(sc, n);

        // Reverse the linked list recursively
        head = reverseList(head);

        // Print reversed list
        printList(head);

        sc.close();
    }
}