package 同位字符串连接的最小长度;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean check(String s, int len) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i += len) {
            int[]tmpCount = new int[26];
            for (int j = i; j < i + len; j++) {
                tmpCount[s.charAt(j) - 'a']++;
            }
            if (i > 0 && !Arrays.equals(tmpCount, count)) {
                return false;
            }
            count = tmpCount;
        }
        return true;
    }
    public int minAnagramLength(String s) {

        int n = s.length();

        for (int len = 1; len < n; len++) {

            if (n % len != 0) {
                continue;
            }
            if (check(s, len)) {
                return len;
            }
        }

        return n;
    }
    public static void main(String[] args) {

        String s = "abba";

        Solution sol = new Solution();
        int ret = sol.minAnagramLength(s);

        System.out.println(ret);
    }
}



