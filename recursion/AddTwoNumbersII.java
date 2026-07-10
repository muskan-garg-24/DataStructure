package recursion;

import java.util.Scanner;

class ListNode {

    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbersII {

    static int carry = 0;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);

        ListNode head = add(l1, len1, l2, len2);

        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    public static int length(ListNode head) {

        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static ListNode add(ListNode l1, int len1, ListNode l2, int len2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode nextNode;
        int sum;

        if (len1 > len2) {

            nextNode = add(l1.next, len1 - 1, l2, len2);

            sum = l1.val + carry;

        } else if (len2 > len1) {

            nextNode = add(l1, len1, l2.next, len2 - 1);

            sum = l2.val + carry;

        } else {

            nextNode = add(l1.next, len1 - 1, l2.next, len2 - 1);

            sum = l1.val + l2.val + carry;
        }

        carry = sum / 10;

        ListNode current = new ListNode(sum % 10);
        current.next = nextNode;

        return current;
    }

    public static ListNode createList(Scanner sc, int n) {

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            ListNode node = new ListNode(sc.nextInt());

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
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

        int n1 = sc.nextInt();
        ListNode l1 = createList(sc, n1);

        int n2 = sc.nextInt();
        ListNode l2 = createList(sc, n2);

        ListNode result = addTwoNumbers(l1, l2);

        printList(result);

        sc.close();
    }
}