package linkedList.reversal_pattern;

import java.util.*;

/*
Problem - Swap Nodes in Pairs

Brute Approach - Store Values In ArrayList And Swap Adjacent Pairs
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Swap Links Iteratively
T.C              - O(n)
S.C              - O(1)
*/

public class SwapNodesInPairs {

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
        }

        // head = swapPairsBrute(head);
        head = swapPairsOptimal(head);

        printList(head);
        sc.close();
    }

    public static ListNode swapPairsBrute(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i + 1 < list.size(); i += 2) {

            int value = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, value);
        }

        temp = head;
        int index = 0;

        while (temp != null) {

            temp.val = list.get(index++);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode swapPairsOptimal(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
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