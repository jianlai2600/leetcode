package 回文数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int x = 121;

        Solution sol = new Solution();
        boolean result = sol.isPalindrome(x);

        System.out.println(result);
    }
}