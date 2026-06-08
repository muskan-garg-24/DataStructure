package linkedList.slow_and_fast_pointer;

import java.util.Scanner;

/*
Problem - Middle Of The Linked List

Brute Approach   - Count total nodes and go to middle
Brute T.C        - O(n)
Brute S.C        - O(1)

Optimal Approach - Slow and Fast Pointer
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class MiddleOfLinkedList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.print("Enter node values: ");

        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();

            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

        }

        sc.close();

        ListNode ans = middleNode(head);

        System.out.println(ans.val);
    }

    public static ListNode middleNodeBrute(ListNode head) {

        int count = 0;

        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int middle = count / 2;

        temp = head;

        while (middle-- > 0) {
            temp = temp.next;
        }

        return temp;
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}