package linkedList.in_place_rearrangement;

import java.util.*;

/*
Problem - Split Linked List in Parts

Brute Approach - Store Nodes In ArrayList
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Length Calculation + In-Place Splitting
T.C              - O(n)
S.C              - O(1)
*/

public class SplitLinkedListInParts {

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

        int k = sc.nextInt();

        ListNode[] parts = splitListToPartsOptimal(head, k);

        for (int i = 0; i < parts.length; i++) {

            System.out.print("Part " + (i + 1) + ": ");

            printList(parts[i]);

            System.out.println();
        }
        sc.close();
    }

    public static ListNode[] splitListToPartsBrute(ListNode head, int k) {

        ArrayList<ListNode> nodes = new ArrayList<>();

        while (head != null) {

            nodes.add(head);
            head = head.next;
        }

        ListNode[] result = new ListNode[k];

        int n = nodes.size();

        int partSize = n / k;
        int extra = n % k;

        int index = 0;

        for (int i = 0; i < k; i++) {

            int currentSize = partSize;

            if (extra > 0) {

                currentSize++;
                extra--;
            }

            if (currentSize == 0) {

                result[i] = null;
                continue;
            }

            result[i] = nodes.get(index);

            index += currentSize;

            nodes.get(index - 1).next = null;
        }

        return result;
    }

    public static ListNode[] splitListToPartsOptimal(ListNode head, int k) {

        int length = 0;

        ListNode current = head;

        while (current != null) {

            length++;
            current = current.next;
        }

        int partSize = length / k;
        int extra = length % k;

        ListNode[] result = new ListNode[k];

        current = head;

        for (int i = 0; i < k; i++) {

            result[i] = current;

            int currentPartSize = partSize;

            if (extra > 0) {

                currentPartSize++;
                extra--;
            }

            for (int j = 1;
                 j < currentPartSize && current != null;
                 j++) {

                current = current.next;
            }

            if (current != null) {

                ListNode nextPart = current.next;

                current.next = null;

                current = nextPart;
            }
        }

        return result;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
