package 清除数字;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String clearDigits(String s) {

        StringBuffer sb = new StringBuffer();
        Stack<Character>stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "cb35";
        Solution sol = new Solution();

        String ret = sol.clearDigits(s);

        System.out.println(ret);
    }
}