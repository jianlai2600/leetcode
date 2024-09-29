package 平衡括号字符串的最少插入次数;

import java.util.Stack;

class Solution {
    public int minInsertions(String s) {

        int res = 0, left = 0, n = s.length();
        //
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                if (i < n - 1 && s.charAt(i + 1) == ')') {
                    if (left == 0) {
                        res++;
                    } else {
                        left--;
                    }
                    i++;
                } else if (i < n - 1 && s.charAt(i + 1) == '(') {
                    if (left == 0) {
                        res += 2;
                    } else {
                        left--;
                        res++;
                    }
                } else {
                    if (left == 0) {
                        res += 2;
                    } else {
                        left--;
                        res++;
                    }
                }
            }
        }
        res += 2 * left;
        return res;
    }
    public static void main(String[] args) {

        String s = "(()))";
        Solution sol = new Solution();

        int ret = sol.minInsertions(s);

        System.out.println(ret);
    }
}