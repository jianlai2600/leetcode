package 设计链表;

class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class MyLinkedList {
        int size;
        ListNode head;
        public MyLinkedList() {
            head = new ListNode(-1);
            size = 0;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode cur = head;

            while (index >= 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode tmp = new ListNode(val);
            tmp.next = head.next;
            head.next = tmp;
            size++;
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            ListNode cur = head;

            while (index > 0) {
                cur = cur.next;
                index--;
            }
            ListNode tmp = new ListNode(val);
            tmp.next = cur.next;
            cur.next = tmp;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }

            ListNode cur = head;

            while (index > 0) {
                cur = cur.next;
                index--;
            }
            cur.next = cur.next.next;
            size--;
        }
    }
}
