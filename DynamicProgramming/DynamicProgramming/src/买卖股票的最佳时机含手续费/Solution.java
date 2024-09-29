package 买卖股票的最佳时机含手续费;

class Solution {
    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int[][]dp = new int[n][2];

        // 0 buy
        // 1 sell

        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[n - 1][1];
    }

    public static void main(String[] args) {

        int[] prices = {1,3,7,5,10,3};
        int fee = 3;

        Solution sol = new Solution();
        int ret = sol.maxProfit(prices, fee);

        System.out.println(ret);
    }
}


