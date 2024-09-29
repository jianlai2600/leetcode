package 重排链表;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode nn = null;

        while (cur != null) {
            nn = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nn;
        }
        return pre;
    }
    public void reorderList(ListNode head) {

        ListNode h1 = head;
        ListNode h2 = h1.next;

        while (h2 == null) {
            return;
        }

        ListNode cur1 = h1;
        ListNode cur2 = h1;

        while (cur2.next != null && cur2.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        h2 = cur1.next;
        cur1.next = null;

        h2 = reverseList(h2);

        cur1 = h1;
        cur2 = h2;

        ListNode t1 = null;
        ListNode t2 = null;

        while (cur2 != null) {

            t1 = cur1.next;
            t2 = cur2.next;

            cur1.next = cur2;
            cur2.next = t1;

            cur1 = t1;
            cur2 = t2;
        }

//        ListNode cur = h1;
//        while (cur != null){
//            System.out.print(cur.val + "->");
//            cur = cur.next;
//        }
//        System.out.println();
//
//        cur = h2;
//        while (cur != null){
//            System.out.print(cur.val + "->");
//            cur = cur.next;
//        }
//        System.out.println();

    }
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode cur = node1;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();

        Solution sol = new Solution();
        sol.reorderList(node1);

        cur = node1;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
