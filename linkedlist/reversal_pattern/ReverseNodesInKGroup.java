package linkedList.reversal_pattern;

import java.util.*;

/*
Problem - Reverse Nodes in K-Group

Brute Approach - Store Nodes In ArrayList And Reverse Every K Group
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Reverse K Nodes In-Place
T.C              - O(n)
S.C              - O(1)
*/

public class ReverseNodesInKGroup {

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

        // head = reverseKGroupBrute(head, k);
        head = reverseKGroupOptimal(head, k);

        printList(head);
        sc.close();
    }

    /*
    Problem - Reverse Nodes in K-Group

    Approach - Store Nodes In ArrayList And Reverse Every K Group
    T.C      - O(n)
    S.C      - O(n)
    */
    public static ListNode reverseKGroupBrute(ListNode head, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {

            list.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i + k <= list.size(); i += k) {

            int left = i;
            int right = i + k - 1;

            while (left < right) {

                int value = list.get(left);
                list.set(left, list.get(right));
                list.set(right, value);

                left++;
                right--;
            }
        }

        temp = head;
        int index = 0;

        while (temp != null) {

            temp.val = list.get(index++);
            temp = temp.next;
        }

        return head;
    }

    /*
    Problem - Reverse Nodes in K-Group

    Approach - Reverse K Nodes In-Place
    T.C      - O(n)
    S.C      - O(1)
    */
    public static ListNode reverseKGroupOptimal(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kthNode = getKthNode(groupPrev, k);

            if (kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            ListNode temp = groupPrev.next;

            groupPrev.next = kthNode;

            groupPrev = temp;
        }

        return dummy.next;
    }

    public static ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {

            curr = curr.next;
            k--;
        }

        return curr;
    }

    public static void printList(ListNode head) {

        while (head != null) {

            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}