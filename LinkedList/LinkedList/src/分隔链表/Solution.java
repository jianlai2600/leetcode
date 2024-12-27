package 分隔链表;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {

        ListNode less = new ListNode(0);
        ListNode lp = less;
        ListNode greater = new ListNode(0);
        ListNode gp = greater;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                lp.next = new ListNode(cur.val);
                lp = lp.next;
            } else {
                gp.next = new ListNode(cur.val);
                gp = gp.next;
            }
            cur = cur.next;
        }

        lp.next = greater.next;

        return less.next;
    }
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        // 手动链接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();

        Solution sol = new Solution();
        ListNode ret = sol.partition(node1, 3);

        cur = ret;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
