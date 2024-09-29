package 比较含退格的字符串;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character>stack1 = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        Stack<Character>stack2 = new Stack<>();
        for (Character c : t.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        return stack1.equals(stack2);

    }
    public static void main(String[] args) {

        String s = "ab#c", t = "ad#c";

        Solution sol = new Solution();
        boolean ret = sol.backspaceCompare(s, t);

        System.out.println(ret);
    }
}