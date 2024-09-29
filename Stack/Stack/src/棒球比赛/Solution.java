package 棒球比赛;

import java.util.Stack;
class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack();

        for (String s : operations) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                int num = stack.pop();
                stack.push(num);
                stack.push(num * 2);
            } else if (s.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.peek();
                int num3 = num1 + num2;
                stack.push(num2);
                stack.push(num3);
            } else {
                int num = Integer.valueOf(s);
                stack.push(num);
            }
        }
        int ret = 0;

        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
    public static void main(String[] args) {

        String[] ops = {"5","2","C","D","+"};
        Solution sol = new Solution();

        int ret = sol.calPoints(ops);

        System.out.println(ret);
    }
}