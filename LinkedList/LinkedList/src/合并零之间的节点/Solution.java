package 合并零之间的节点;

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
    public ListNode mergeNodes(ListNode head) {

        ListNode cur = head;
        int curSum = 0;
        ListNode ret = new ListNode(0);
        ListNode node = ret;

        while (cur != null) {

            if (cur.val == 0) {
                ListNode tmp = new ListNode(curSum);
                node.next = tmp;
                node = node.next;
                curSum = 0;
            } else {
                curSum += cur.val;
            }
            cur = cur.next;
        }

        return ret.next.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode cur = node1;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();

        Solution sol = new Solution();
        ListNode ret = sol.mergeNodes(node1);

        cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
