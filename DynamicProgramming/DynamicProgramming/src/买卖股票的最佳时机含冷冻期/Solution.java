package 买卖股票的最佳时机含冷冻期;

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][]dp = new int[n][4];

        dp[0][0] = -prices[0];

        // 0 buy
        // 1 sell
        // 2 sell today
        // 3 freeze

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(Math.max(dp[n - 1][1], dp[n - 1][2]), dp[n - 1][3]);
    }

    public static void main(String[] args) {

        int[] prices = {1,2,3,0,2};

        Solution sol = new Solution();
        int ret = sol.maxProfit(prices);

        System.out.println(ret);
    }
}


