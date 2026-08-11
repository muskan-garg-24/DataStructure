package linkedList.slow_and_fast_pointer;

import java.util.HashSet;

/*
Problem - Linked List Cycle II

Brute Approach   - HashSet
Brute T.C        - O(n)
Brute S.C        - O(n)

Optimal Approach - Floyd's Cycle Detection Algorithm / Slow and Fast Pointer
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class LinkedListCycleII {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode detectCycleBrute(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {

            if (set.contains(curr)) {
                return curr;
            }

            set.add(curr);
            curr = curr.next;
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode entry = head;

                while (entry != slow) {

                    entry = entry.next;
                    slow = slow.next;
                }

                return entry;
            }
        }

        return null;
    }
} 