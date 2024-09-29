package 验证回文串;

import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int left = 0, right =s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {

        String s = "0P";
        Solution sol = new Solution();

        boolean ret = sol.isPalindrome(s);

        System.out.println(ret);
    }
}