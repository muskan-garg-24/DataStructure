package linkedList.traversal_and_manipulation;

import java.util.*;

/*
Problem - Convert Binary Number in a Linked List to Integer (LC 1290)

Brute Approach - Store Binary String Then Convert
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Basic Traverse and Build Decimal
T.C              - O(n)
S.C              - O(1)
*/

public class BinaryLinkedListToDecimal {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {

                head = tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
            sc.close();
        }

        // System.out.println(getDecimalValueBrute(head));
        System.out.println(getDecimalValueOptimal(head));
    }

    public static int getDecimalValueBrute(ListNode head) {

        StringBuilder binary = new StringBuilder();

        while (head != null) {

            binary.append(head.val);

            head = head.next;
        }

        return Integer.parseInt(binary.toString(), 2);
    }

    public static int getDecimalValueOptimal(ListNode head) {

        int decimal = 0;

        while (head != null) {

            decimal = decimal * 2 + head.val;

            // OR
            // decimal = (decimal << 1) | head.val;

            head = head.next;
        }

        return decimal;
    }
}
