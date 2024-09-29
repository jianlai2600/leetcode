package 随机链表的复制;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        Node dummyNode = new Node(0);
        Node n1 = new Node(head.val);
        Node pre = n1, cur = head.next;
        dummyNode.next = n1;

        map.put(head, n1);

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            pre.next = map.get(cur);
            pre = map.get(cur);

            cur = cur.next;
        }

        for (Node node : map.keySet()) {
            map.get(node).random = map.get(node.random);
        }

        return dummyNode.next;
    }
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Solution sol = new Solution();
        Node ret = sol.copyRandomList(node1);

        Node cur = new Node(0);
        cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
