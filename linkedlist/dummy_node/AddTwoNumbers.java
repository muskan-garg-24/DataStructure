package linkedList.dummy_node;

import java.util.*;

/*
Problem - Add Two Numbers

Brute Approach - Convert Lists To Numbers, Add And Create Result List
T.C            - O(n + m)
S.C            - O(max(n, m))

Optimal Approach - Dummy Node + Carry Simulation
T.C              - O(max(n, m))
S.C              - O(max(n, m))
*/

public class AddTwoNumbers {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        ListNode list1 = null;
        ListNode tail1 = null;

        for (int i = 0; i < n1; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (list1 == null) {
                list1 = tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        int n2 = sc.nextInt();

        ListNode list2 = null;
        ListNode tail2 = null;

        for (int i = 0; i < n2; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (list2 == null) {
                list2 = tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        // ListNode result = addTwoNumbersBrute(list1, list2);
        ListNode result = addTwoNumbersOptimal(list1, list2);

        printList(result);
        sc.close();
    }

    public static ListNode addTwoNumbersBrute(ListNode l1, ListNode l2) {

        long num1 = 0;
        long num2 = 0;
        long place = 1;

        while (l1 != null) {

            num1 += l1.val * place;
            place *= 10;
            l1 = l1.next;
        }

        place = 1;

        while (l2 != null) {

            num2 += l2.val * place;
            place *= 10;
            l2 = l2.next;
        }

        long sum = num1 + num2;

        if (sum == 0) {
            return new ListNode(0);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (sum > 0) {

            tail.next = new ListNode((int)(sum % 10));
            tail = tail.next;

            sum /= 10;
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {

                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {

                sum += l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}