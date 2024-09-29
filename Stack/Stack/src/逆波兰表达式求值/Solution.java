package 逆波兰表达式求值;

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer>stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(val1 + val2);
            } else if (s.equals("-")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(val1 - val2);
            } else if (s.equals("*")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(val1 * val2);
            } else if (s.equals("/")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(val1 / val2);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2","1","+","3","*"};
        Solution sol = new Solution();

        int ret = sol.evalRPN(tokens);

        System.out.println(ret);
    }
}