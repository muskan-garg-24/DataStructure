package linkedList.two_pointer_gap;

import java.util.*;

/*
Problem - Intersection of Two Linked Lists

Brute Approach - Store First List Nodes In HashSet
T.C            - O(n + m)
S.C            - O(n)

Optimal Approach - Two Pointer Alignment
T.C              - O(n + m)
S.C              - O(1)
*/

public class IntersectionOfTwoLinkedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /*
           Common Part:
           8 -> 4 -> 5
        */

        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        /*
           List A:
           4 -> 1 -> 8 -> 4 -> 5
        */

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        /*
           List B:
           5 -> 6 -> 1 -> 8 -> 4 -> 5
        */

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // ListNode intersection = getIntersectionNodeBrute(headA, headB);
        ListNode intersection = getIntersectionNodeOptimal(headA, headB);

        if (intersection != null) {
            System.out.println(intersection.val);
        } else {
            System.out.println(-1);
        }
    }

    public static ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {

        HashSet<ListNode> visited = new HashSet<>();

        while (headA != null) {

            visited.add(headA);
            headA = headA.next;
        }

        while (headB != null) {

            if (visited.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            pointerA = (pointerA == null) ? headB : pointerA.next;

            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }
}