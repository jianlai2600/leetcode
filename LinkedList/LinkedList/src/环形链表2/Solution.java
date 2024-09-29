package 环形链表2;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                ListNode chase = head;
                while (chase != slow) {
                    chase = chase.next;
                    slow = slow.next;
                }
                return chase;
            }
        }

        return null;
    }
    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        a1.next = a2;

        Solution sol = new Solution();
        ListNode ret = sol.detectCycle(a1);

//        System.out.println(ret.val);
    }
}
