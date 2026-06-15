package linkedList.cycle_detection_pattern;

import java.util.*;

/*
Problem - Find Length of Loop

Brute Approach - HashMap To Store First Occurrence Of Node
T.C            - O(n)
S.C            - O(n)

Optimal Approach - Floyd Cycle Detection + Count Cycle Length
T.C              - O(n)
S.C              - O(1)
*/

public class FindLengthOfLoop {

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
        Enter loop position:

        0 -> No Loop
        1 -> Connect tail to 1st node
        2 -> Connect tail to 2nd node
        ...
        */

        int loopPosition = sc.nextInt();

        if (loopPosition > 0) {

            tail.next = nodes.get(loopPosition - 1);
        }

        // System.out.println(findLengthBrute(head));
        System.out.println(findLengthOptimal(head));
        sc.close();
    }

    public static int findLengthBrute(Node head) {

        HashMap<Node, Integer> map = new HashMap<>();

        int index = 0;

        Node current = head;

        while (current != null) {

            if (map.containsKey(current)) {

                return index - map.get(current);
            }

            map.put(current, index);

            current = current.next;
            index++;
        }

        return 0;
    }

    public static int findLengthOptimal(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int length = 1;

                Node current = slow.next;

                while (current != slow) {

                    length++;
                    current = current.next;
                }

                return length;
            }
        }

        return 0;
    }
}