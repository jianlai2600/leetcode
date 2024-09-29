package 每种字符至少取K个;

import java.util.*;

class Solution {
    public int takeCharacters(String s, int k) {

        int n = s.length();

        int a = 0, b = 0, c = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else {
                c++;
            }
        }
        if (a < k || b < k || c < k) {
            return -1;
        }

        int ta = a - k, tb = b - k, tc = c - k;
        int left = 0, right = 0;
        int ca = 0, cb = 0, cc = 0;
        int maxLen = 0;

        while (right < n) {
            char ch = s.charAt(right);
            if (ch == 'a') {
                ca++;
            } else if (ch == 'b') {
                cb++;
            } else {
                cc++;
            }
            while (ca > ta || cb > tb || cc > tc) {
                char leftChar = s.charAt(left);
                if (leftChar == 'a') {
                    ca--;
                } else if (leftChar == 'b') {
                    cb--;
                } else {
                    cc--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return n - maxLen;
    }
    public static void main(String[] args) {

        String s = "aabaaaacaabc";
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.takeCharacters(s, k);

        System.out.println(ret);
    }
}