package 旋转链表;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode last = dummy;
        int cnt = 0;
        while (last.next != null) {
            last = last.next;
            cnt++;
        }

        k = k % cnt;

        if (k == 0) {
            return dummy.next;
        }

        ListNode cur = dummy;
        int step = cnt - k;
        while (step != 0) {
            cur = cur.next;
            step--;
        }

        ListNode newHead = cur.next;

        dummy.next = newHead;
        last.next = head;
        cur.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;

        ListNode cur = node1;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();

        Solution sol = new Solution();
        ListNode ret = sol.rotateRight(node1, 2);

        cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
