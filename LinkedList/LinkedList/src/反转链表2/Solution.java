package 反转链表2;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode nn = null;

        while (cur != null) {
            nn = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nn;
        }

        return pre;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        //
        ListNode walker = dummy;
        int dis = 0;
        ListNode pre = null, last = null, ln = null, rn = null;
        while (walker != null) {

            if (dis == left - 1) {
                pre = walker;
                ln = pre.next;
            }
            if (dis == right) {
                rn = walker;
                last = rn.next;
            }
            walker = walker.next;
            dis++;
        }
        //
        walker = ln;
        while (walker != rn) {
            ListNode nn = walker.next;
            walker.next = last;
            last = walker;
            walker = nn;
        }
        walker.next = last;
        pre.next = walker;
        //
        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode cur = node1;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
        //
        Solution sol = new Solution();
        ListNode res = sol.reverseBetween(node1, 2, 4);
        //
        cur = res;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
