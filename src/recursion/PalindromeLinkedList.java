package recursion;

import java.util.Scanner;

public class PalindromeLinkedList {

    static Node left;

    // Recursive function to check palindrome
    public static boolean isPalindrome(Node head) {
        left = head;
        return checkPalindrome(head);
    }

    private static boolean checkPalindrome(Node right) {

        // Base Case
        if (right == null) {
            return true;
        }

        // Recurse till the last node
        if (!checkPalindrome(right.next)) {
            return false;
        }

        // Compare current nodes
        if (left.data != right.data) {
            return false;
        }

        // Move left pointer ahead
        left = left.next;

        return true;
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = createList(sc, n);

        System.out.println(isPalindrome(head));

        sc.close();
    }
}