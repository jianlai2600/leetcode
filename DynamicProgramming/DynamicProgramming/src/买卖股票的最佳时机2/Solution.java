package 买卖股票的最佳时机2;

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        return dp[n - 1][1];
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        Solution sol = new Solution();
        int ret = sol.maxProfit(prices);

        System.out.println(ret);
    }
}


