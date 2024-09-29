package 删除排序链表中的重复元素;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode();
        ListNode cur = new ListNode();
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        pre = head;
        cur = head.next;

        while (cur != null) {
            if (pre.val == cur.val) {
                while (cur != null && pre.val == cur.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution sol = new Solution();
        ListNode ret = sol.deleteDuplicates(node1);

        ListNode cur;
        cur = ret;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
