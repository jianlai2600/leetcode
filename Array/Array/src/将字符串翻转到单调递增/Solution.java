package 将字符串翻转到单调递增;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minFlipsMonoIncr(String s) {

        int n = s.length();
        int[]preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + s.charAt(i) - '0';
        }

        int res = Integer.MAX_VALUE;
        int cur = 0;

        for (int i = 0; i <= n; i++) {
            int suffix = preSum[n] - preSum[i];
            int prefix = preSum[i];

            cur = prefix + (n - i - suffix);
            if (cur < res) {
                res = cur;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        String s = "00011000";

        Solution sol = new Solution();
        int ret = sol.minFlipsMonoIncr(s);

        System.out.println(ret);
    }
}