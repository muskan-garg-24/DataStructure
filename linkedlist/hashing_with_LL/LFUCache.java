package linkedList.hashing_with_LL;
import java.util.*;

class LFUCache {

    class Node {

        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;

        int size;

        DoublyLinkedList() {

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }

    private int capacity;
    private int minFreq;

    private HashMap<Integer, Node> keyToNode;

    private HashMap<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        this.minFreq = 0;

        keyToNode = new HashMap<>();

        freqToList = new HashMap<>();
    }

    public int get(int key) {

        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            node.value = value;

            updateFrequency(node);

            return;
        }

        if (keyToNode.size() == capacity) {

            DoublyLinkedList minFreqList = freqToList.get(minFreq);

            Node nodeToRemove = minFreqList.removeLast();

            keyToNode.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        DoublyLinkedList list = freqToList.getOrDefault(1, new DoublyLinkedList());

        list.addFirst(newNode);

        freqToList.put(1, list);

        keyToNode.put(key, newNode);
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqToList.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq &&
            oldList.size == 0) {

            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList = freqToList.getOrDefault(node.freq, new DoublyLinkedList());

        newList.addFirst(node);

        freqToList.put(node.freq, newList);
    }
}