package recursion;

import java.util.Scanner;

public class CompareTwoLinkedLists {

    public static int compare(Node head1, Node head2) {

        // Both strings ended
        if (head1 == null && head2 == null) {
            return 0;
        }

        // First string ended first
        if (head1 == null) {
            return -1;
        }

        // Second string ended first
        if (head2 == null) {
            return 1;
        }

        // Compare current characters
        if (head1.data > head2.data) {
            return 1;
        }

        if (head1.data < head2.data) {
            return -1;
        }

        // Characters are equal
        return compare(head1.next, head2.next);
    }

    public static Node createList(Scanner sc, int n) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            char ch = sc.next().charAt(0);

            Node newNode = new Node(ch);

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

        int n1 = sc.nextInt();
        Node head1 = createList(sc, n1);

        int n2 = sc.nextInt();
        Node head2 = createList(sc, n2);

        System.out.println(compare(head1, head2));

        sc.close();
    }
}