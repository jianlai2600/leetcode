package 基本计算器2;

import java.util.*;

class Solution {
    public int calculate(String s) {

        // 这道题的思路太细了，真不行，得反复看
        Stack<Integer>stack = new Stack<>();

        char op = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }

                op = c;
                num = 0;
            }
        }

        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
    public static void main(String[] args) {

        String s = " 3/2 ";

        Solution sol = new Solution();
        int ret = sol.calculate(s);

        System.out.println(ret);
    }
}