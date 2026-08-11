package linkedList.hashing_with_LL;
import java.util.*;

/*
Problem - Linked List Components (LC 817)

Brute Approach - For Every Node Search In nums Array
T.C            - O(n * m)
S.C            - O(1)

Optimal Approach - HashSet + Linked List Traversal
T.C              - O(n + m)
S.C              - O(m)
*/

public class LinkedListComponents {

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

        int m = sc.nextInt();

        int[] nums = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }
       
        // System.out.println(numComponentsBrute(head, nums));
        System.out.println(numComponentsOptimal(head, nums));
        sc.close();
    }

    public static int numComponentsBrute(ListNode head, int[] nums) {

        int components = 0;

        ListNode current = head;

        while (current != null) {

            boolean currentPresent = contains(nums, current.val);

            boolean nextPresent = false;

            if (current.next != null) {
                nextPresent = contains(nums, current.next.val);
            }

            if (currentPresent &&
               (current.next == null || !nextPresent)) {

                components++;
            }

            current = current.next;
        }

        return components;
    }

    public static int numComponentsOptimal(ListNode head, int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int components = 0;

        ListNode current = head;

        while (current != null) {

            if (set.contains(current.val) &&
               (current.next == null || !set.contains(current.next.val))) {

                components++;
            }

            current = current.next;
        }

        return components;
    }

    public static boolean contains(int[] nums, int target) {

        for (int num : nums) {

            if (num == target) {
                return true;
            }
        }

        return false;
    }
}