package recursion;

import java.util.Scanner;

public class LinkedListDeleteAtPosition {

    // Recursive function to delete node at given position (1-based indexing)
    public static Node deleteAtPosition(Node head, int pos) {

        // Base Case: Empty list
        if (head == null) {
            return null;
        }

        // Base Case: Delete first node
        if (pos == 1) {
            return head.next;
        }

        // Recursively delete from the remaining list
        head.next = deleteAtPosition(head.next, pos - 1);

        return head;
    }

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

        // Position to delete (1-based)
        int pos = sc.nextInt();

        // Delete node recursively
        head = deleteAtPosition(head, pos);

        // Print updated list
        printList(head);

        sc.close();
    }
}