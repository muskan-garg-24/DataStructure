package recursion;

import java.util.Scanner;

public class ReverseDoublyLinkedList {

    public static Node reverse(Node head) {

        // Base Case
        if (head == null) {
            return null;
        }

        // Swap next and prev
        Node temp = head.next;
        head.next = head.prev;
        head.prev = temp;

        // If original next was null, this becomes new head
        if (head.prev == null) {
            return head;
        }

        return reverse(head.prev);
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
                newNode.prev = tail;
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

        int n = sc.nextInt();

        Node head = createList(sc, n);

        head = reverse(head);

        printList(head);

        sc.close();
    }
} 