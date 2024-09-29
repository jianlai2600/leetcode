package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int val;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    Node head;
    Node tail;
    int size;
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    // LRU
    public LRUCache(int capacity) {

        size = 0;
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = deleteNode(map.get(key));
        addToHead(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = deleteNode(map.get(key));
            node.val = value;
            map.put(key, node);
            addToHead(node);
        } else {
            size++;
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

            if (size > capacity) {
                Node del = deleteLastNode();
                map.remove(del.key);
                size--;
            }
        }
    }
    public Node deleteNode(Node node) {

        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    public void addToHead(Node node) {

        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public Node deleteLastNode() {

        Node node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;

        return node;
    }
}
