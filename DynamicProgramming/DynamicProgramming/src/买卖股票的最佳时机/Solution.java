package 买卖股票的最佳时机;

import javax.print.DocFlavor;
import java.util.LinkedList;

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        int[][]dp = new int[n][2];

        // 0 为当前持有，两个状态，前一天持有 或者 今天买入
        // 1 为当前不持有，两个状态，前一天不持有 或者 今天卖出

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        int ret = 0;

        for (int i = 1; i < n; i++) {
            /**
             * 如果第i天持有股票即dp[i][0]， 那么可以由两个状态推出来
             *
             * 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：dp[i - 1][0]
             * 第i天买入股票，所得现金就是买入今天的股票后所得现金即：-prices[i]
             * 那么dp[i][0]应该选所得现金最大的，所以dp[i][0] = max(dp[i - 1][0], -prices[i]);
             *
             * 如果第i天不持有股票即dp[i][1]， 也可以由两个状态推出来
             *
             * 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：dp[i - 1][1]
             * 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：prices[i] + dp[i - 1][0]
             * 同样dp[i][1]取最大的，dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
             */
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        // 选 dp[n - 1][1] 因为本题中不持有股票状态所得金钱一定比持有股票状态得到的多！
        return dp[n - 1][1];
    }
    public int maxProfit2(int[] prices) {

        int n = prices.length;
        int[][]dp = new int[n][2];
        // 0 no
        // 1 have
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        Solution sol = new Solution();
        int ret = sol.maxProfit(prices);

        System.out.println(ret);
    }
}


