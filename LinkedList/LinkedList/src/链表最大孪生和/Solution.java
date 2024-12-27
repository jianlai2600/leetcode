package 链表最大孪生和;

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
    public int pairSum(ListNode head) {

        List<Integer>list = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            int sum = list.get(i) + list.get(list.size() - i - 1);
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);

        // 手动链接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode cur = node1;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();

        Solution sol = new Solution();
        int ret = sol.pairSum(node1);

        System.out.println(ret);
    }
}
