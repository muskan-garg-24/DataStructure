package recursion;

import java.util.Scanner;

public class InsertionAtAGivenPositionInALinkedList {

    // Recursive function to insert a node at the given position (1-based indexing)
    public static Node insertPos(Node head, int pos, int val) {

        // Base Case: Insert at the beginning
        if (pos == 1) {
            Node newNode = new Node(val);
            newNode.next = head;
            return newNode;
        }

        // Base Case: Position is invalid
        if (head == null) {
            return null;
        }

        // Recursively move to the desired position
        head.next = insertPos(head.next, pos - 1, val);

        return head;
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

        // Position (1-based) and value to insert
        int pos = sc.nextInt();
        int val = sc.nextInt();

        // Insert recursively
        head = insertPos(head, pos, val);

        // Print updated list
        printList(head);

        sc.close();
    }
}
