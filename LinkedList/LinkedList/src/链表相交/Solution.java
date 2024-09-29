package 链表相交;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA, pB = headB;

        if (pA == null || pB == null) {
            return null;
        }
        while (pA != pB) {

            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(8);

        ListNode node1 = new ListNode(100);
        ListNode node2 = new ListNode(200);
        ListNode node3 = new ListNode(300);

        a1.next = a2;
        a2.next = a3;
        a3.next = node1;

        b1.next = b2;
        b2.next = node1;

        node1.next = node2;
        node2.next = node3;

        Solution sol = new Solution();
        ListNode ret = sol.getIntersectionNode(a1, b1);

        System.out.println(ret.val);
    }
}
