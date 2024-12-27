package 括号的分数;

import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer>stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                if (stack.peek() == -1) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int num = 0;
                    while (!stack.isEmpty() && stack.peek() != -1) {
                        num += stack.pop();
                    }
                    stack.pop();
                    stack.add(num * 2);
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "()()";
        Solution sol = new Solution();

        int ret = sol.scoreOfParentheses(s);

        System.out.println(ret);
    }
}