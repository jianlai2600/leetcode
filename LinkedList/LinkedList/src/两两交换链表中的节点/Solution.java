package 两两交换链表中的节点;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {

        ListNode cur = head;

        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;

        ListNode nn = null;
        ListNode nnn = null;

        while (cur != null && cur.next != null) {
            nn = cur.next;
            nnn = nn.next;

            pre.next = nn;
            nn.next = cur;
            cur.next = nnn;

            pre = cur;
            cur = nnn;
        }

        return dummyHead.next;
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
        ListNode ret = sol.swapPairs(node1);

        cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
