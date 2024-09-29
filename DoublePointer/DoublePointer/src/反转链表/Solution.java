package 反转链表;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public String reverseWords(String s) {

        int n = s.length();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder(n);

        int i = n - 1;

        while (i >= 0) {
            while (i >= 0 && c[i] == ' ') {
                i--;
            }
            StringBuilder word = new StringBuilder(n);
            while (i >= 0 && c[i] != ' ') {
                word.append(c[i]);
                i--;
            }
            if (!word.isEmpty()) {
                sb.append(word.reverse() + " ");
            }

        }
        sb.deleteCharAt(sb.length()-1);

        return  sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "the sky is blue";

        Solution sol = new Solution();
        String ret = sol.reverseWords(s);

        System.out.println(ret);
    }
}
