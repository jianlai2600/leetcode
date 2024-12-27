package 字符串及其反转中是否存在同一子字符串;

import java.util.*;

class Solution {
    public boolean isSubstringPresent(String s) {

        StringBuilder sb = new StringBuilder(s).reverse();

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.contains(sb.substring(i, i + 2))) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        String s = "leetcode";

        Solution sol = new Solution();
        boolean result = sol.isSubstringPresent(s);

        System.out.println(result);
    }
}