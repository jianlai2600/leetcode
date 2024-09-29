package 有效的括号;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

class Solution {

    public boolean isValid(String s) {
        Map<Character, Character>map = new HashMap<>() {{
           put(')', '(');
           put(']', '[');
           put('}', '{');
        }};

        Stack<Character>stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[]{}";

        Solution sol = new Solution();
        boolean ret = sol.isValid(s);

        System.out.println(ret);
    }
}