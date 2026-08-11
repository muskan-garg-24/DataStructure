package linkedList.hashing_with_LL;
import java.util.*;
/*
Problem - LRU Cache

Approach - HashMap + Doubly Linked List
T.C      - O(1) for get and put
S.C      - O(capacity)
*/

class LRUCache {

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            insertAtFront(node);

            return;
        }

        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);

            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insertAtFront(newNode);

        map.put(key, newNode);
    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}