package 反转字符串2;

import java.util.Arrays;

class Solution {

    public void helperFun(char[]s, int left, int right) {

        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
    public String reverseStr(String s, int k) {

        char[]c = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            helperFun(c, i, Math.min(i + k - 1, n - 1));
        }
        return String.valueOf(c);
    }
    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;

        Solution sol = new Solution();
        String ret = sol.reverseStr(s, k);

        System.out.println(ret);
    }
}