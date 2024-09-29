package 判断一个括号字符串是否有效;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean canBeValid(String s, String locked) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')' && locked.charAt(i) == '1') {
                r++;
            }
            if (i + 1 - r < r) {
                return false;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' && locked.charAt(i) == '1') {
                l++;
            }
            if (n - i - l < l) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "))()))", locked = "010100";

        Solution sol = new Solution();
        boolean ret = sol.canBeValid(s, locked);

        System.out.println(ret);
    }
}