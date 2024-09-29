package 完全平方数;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSquares(int n) {

        int[]dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i * i <= n; i++) {
            int num = i * i;
            for (int j = num; j <= n; j++) {
                if (dp[j - num] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - num] + 1);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 12;

        Solution sol = new Solution();
        int ret = sol.numSquares(n);

        System.out.println(ret);
    }
}


