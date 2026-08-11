package recursion;

import java.util.Scanner;

public class SearchInLinkedList {

    // Recursive function to search for a key
    public static boolean searchKey(Node head, int key) {

        // Base Case: Reached end of list
        if (head == null) {
            return false;
        }

        // Base Case: Key found
        if (head.data == key) {
            return true;
        }

        // Recursively search in the remaining list
        return searchKey(head.next, key);
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

        // Number of nodes
        int n = sc.nextInt();

        // Create linked list
        Node head = createList(sc, n);

        // Key to search
        int key = sc.nextInt();

        // Print result
        System.out.println(searchKey(head, key));

        sc.close();
    }
}
