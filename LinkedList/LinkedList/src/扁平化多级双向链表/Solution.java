package 扁平化多级双向链表;

import java.util.Stack;

class Solution {
    static class Node {
        Node (int v) {
            this.val = v;
        }
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        head.prev = dummy;

        Node cur = head;
        Node pre = dummy;

        Stack<Node>stack = new Stack<>();

        while (cur != null) {

            pre.next = cur;
            cur.prev = pre;

            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;


            }
            pre = cur;
            cur = cur.next;

            if (cur == null && !stack.isEmpty()) {
                cur = stack.pop();
            }
        }

        dummy.next.prev = null;
        return dummy.next;
    }
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;

        node2.child = node4;
        node4.child = node5;

        Solution sol = new Solution();
        Node ret = sol.flatten(node1);

        Node cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
