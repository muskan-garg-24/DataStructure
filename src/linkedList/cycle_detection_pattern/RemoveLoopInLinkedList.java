package linkedList.cycle_detection_pattern;

import java.util.*;

/*
Problem - Remove Loop in Linked List

Brute Approach - HashSet To Detect Repeated Node
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Floyd Cycle Detection + Find Loop Start + Break Loop
T.C              - O(n)
S.C              - O(1)
*/

public class RemoveLoopInLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            nodes.add(newNode);

            if (head == null) {

                head = tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        /*
        Loop Position

        0 -> No Loop
        1 -> Tail connects to 1st node
        2 -> Tail connects to 2nd node
        ...
        */

        int loopPosition = sc.nextInt();

        if (loopPosition > 0) {

            tail.next = nodes.get(loopPosition - 1);
        }

        // removeLoopBrute(head);
        removeLoopOptimal(head);

        printList(head);
        sc.close();
    }

    public static void removeLoopBrute(Node head) {

        HashSet<Node> visited = new HashSet<>();

        Node prev = null;
        Node current = head;

        while (current != null) {

            if (visited.contains(current)) {

                prev.next = null;
                return;
            }

            visited.add(current);

            prev = current;
            current = current.next;
        }
    }

    public static void removeLoopOptimal(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        boolean hasLoop = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            return;
        }

        slow = head;

        // Special Case:
        // Loop starts from head

        if (slow == fast) {

            while (fast.next != slow) {
                fast = fast.next;
            }

            fast.next = null;
            return;
        }

        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
    }

    public static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}