package 鸡蛋掉落;

import java.util.Arrays;

class Solution {

    public int twoEggDrop(int n) {

        int[]dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = Math.min(dp[i], Math.max(dp[i - k], k - 1) + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 2;

        Solution sol = new Solution();
        int res = sol.twoEggDrop(n);

        System.out.println(res);
    }
}


