package 零钱兑换2;

import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {

        // 外物内包 组合
        // 外包内物 排列
        int[]dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 5;

        Solution sol = new Solution();
        int ret = sol.change(amount, coins);

        System.out.println(ret);
    }
}


