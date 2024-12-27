package 两数相加2;

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

        while (cur != null) {
            ListNode nn = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nn;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        ListNode p1 = r1;
        ListNode p2 = r2;

        ListNode res = new ListNode();
        ListNode cur = res;

        int add = 0;
        while (p1 != null || p2 != null) {

            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;

            int sum = v1 + v2 + add;

            ListNode tmp = new ListNode(sum % 10);
            cur.next = tmp;
            cur = cur.next;

            add = sum / 10;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (add != 0) {
            ListNode tmp = new ListNode(add);
            cur.next = tmp;
        }

        ListNode rRes = reverseList(res.next);
        return rRes;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(5);

        ListNode node5 = new ListNode(5);

        Solution sol = new Solution();
        ListNode ret = sol.addTwoNumbers(node1, node5);

        ListNode cur = ret;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }
}
