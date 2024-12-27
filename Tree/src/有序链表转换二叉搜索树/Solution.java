package 有序链表转换二叉搜索树;

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
    public TreeNode helper(List<Integer>list, int left, int right) {

        if (left == right) {
            return new TreeNode(list.get(left));
        }
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode res = new TreeNode(list.get(mid));
        res.left = helper(list, left, mid - 1);
        res.right = helper(list, mid + 1, right);

        return res;
    }
    public TreeNode sortedListToBST(ListNode head) {

        ListNode cur = head;
        List<Integer> list = new ArrayList<>();

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int n = list.size();

        TreeNode res = helper(list, 0, n - 1);

        return res;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution sol = new Solution();
        TreeNode ret = sol.sortedListToBST(node1);

        System.out.println(ret.val);
    }
}

