package 爬楼梯;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int climbStairs(int n) {

        if (n < 2) {
            return 1;
        }
        int[]dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 2;

        Solution sol = new Solution();
        int ret = sol.climbStairs(n);

        System.out.println(ret);
    }
}


