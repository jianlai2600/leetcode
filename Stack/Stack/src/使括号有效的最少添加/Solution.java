package 使括号有效的最少添加;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Character>stack = new Stack<>();

        int res = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(c);
                    }
                } else {
                    res++;
                }
            }
        }

        while (!stack.isEmpty() && stack.peek() == '(') {
            res++;
            stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {

        String s = ")))";
        Solution sol = new Solution();

        int ret = sol.minAddToMakeValid(s);

        System.out.println(ret);
    }
}