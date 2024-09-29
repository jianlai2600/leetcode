package 移除无效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Integer>stack = new Stack<>();

        boolean[]isValid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!stack.isEmpty()) {
                    isValid[stack.pop()] = true;
                    isValid[i] = true;
                }
            } else if (c == '('){
                stack.push(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (isValid[i]) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "))((";

        Solution sol = new Solution();
        String ret = sol.minRemoveToMakeValid(s);

        System.out.println(ret);
    }
}