package 简化路径;

import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        StringBuffer sb = new StringBuffer();

        Stack<String> stack = new Stack<>();
        String[]arr = path.split("/+");

        for (String s : arr) {

            if (s.isEmpty() || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                int cnt = 2;
                while (!stack.isEmpty() && cnt != 0) {
                    stack.pop();
                    cnt--;
                }
            } else {
                stack.push("/");
                stack.push(s);
            }
        }
        // make return string
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        String path = "/../";

        Solution sol = new Solution();
        String ret = sol.simplifyPath(path);

        System.out.println(ret);
    }
}