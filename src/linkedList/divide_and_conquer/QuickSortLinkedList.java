package linkedList.divide_and_conquer;

import java.util.*;

/*
Problem - Quick Sort on Singly Linked List

Brute Approach - Convert LL to Array, sort, rebuild
T.C            - O(n log n)
S.C            - O(n)

Optimal Approach - In-place QuickSort using partitioning
T.C              - O(n log n) average, O(n^2) worst
S.C              - O(log n) recursion stack
*/

public class QuickSortLinkedList {

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

        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {

            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = quickSort(head);

        printList(head);
        sc.close();
    }

    public static Node bruteSort(Node head) {

        List<Integer> list = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.data = list.get(i++);
            temp = temp.next;
        }

        return head;
    }

    public static Node quickSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        int pivot = head.data;

        Node sH = null, sT = null;
        Node eH = null, eT = null;
        Node gH = null, gT = null;

        Node curr = head;

        while (curr != null) {

            if (curr.data < pivot) {
                Node[] res = insert(sH, sT, curr.data);
                sH = res[0];
                sT = res[1];
            }
            else if (curr.data == pivot) {
                Node[] res = insert(eH, eT, curr.data);
                eH = res[0];
                eT = res[1];
            }
            else {
                Node[] res = insert(gH, gT, curr.data);
                gH = res[0];
                gT = res[1];
            }

            curr = curr.next;
        }

        sH = quickSort(sH);
        gH = quickSort(gH);

        return concatenate(sH, eH, gH);
    }

    // insert helper
    public static Node[] insert(Node head, Node tail, int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        return new Node[]{head, tail};
    }

    // concatenate 3 lists
    public static Node concatenate(Node a, Node b, Node c) {

        Node head = null;

        head = append(head, a);
        head = append(head, b);
        head = append(head, c);

        return head;
    }

    public static Node append(Node head, Node sub) {

        if (sub == null) return head;

        if (head == null) return sub;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = sub;

        return head;
    }

    // print list
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }
}