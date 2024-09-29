package 买卖股票的最佳时机2;

import java.util.Map;

class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int ret = 0;

        for (int i = 0; i < n - 1; i++) {
            int profit = prices[i + 1] - prices[i];
            if (profit > 0) {
                ret += profit;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        Solution sol = new Solution();

        int ret = sol.maxProfit(prices);

        System.out.println(ret);
    }
}

