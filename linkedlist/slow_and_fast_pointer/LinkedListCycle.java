package linkedList.slow_and_fast_pointer;

import java.util.HashSet;

/*
Problem - Linked List Cycle

Brute Approach   - HashSet of visited nodes
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Slow and Fast Pointer
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class LinkedListCycle {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head.next.next.next.next = head.next;

        //System.out.println("Brute: " + hasCycleBrute(head));
        System.out.println("Optimal: " + hasCycle(head));
    }

    public static boolean hasCycleBrute(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {

            if (set.contains(curr)) {
                return true;
            }

            set.add(curr);
            curr = curr.next;
        }

        return false;
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}