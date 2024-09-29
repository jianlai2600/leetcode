package 删除字符串中的所有相邻重复项;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        Stack<Character>stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuffer sb = new StringBuffer();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "abbaca";
        Solution sol = new Solution();
        String ret = sol.removeDuplicates(s);

        System.out.println(ret);
    }
}