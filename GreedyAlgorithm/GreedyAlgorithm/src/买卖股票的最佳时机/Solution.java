package 买卖股票的最佳时机;

import java.util.*;

class Solution {

    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        int n = prices.length;

        for (int i = 0; i < n; i++){
            if (prices[i] < min_price){
                min_price = prices[i];
            }
            max_profit = Integer.max(max_profit, prices[i] - min_price);
        }
        return max_profit;
    }

    public static void main(String[] args)
    {
        int[] prices = {7,1,5,3,6,4};

        Solution sol = new Solution();

        int ret = sol.maxProfit(prices);

        System.out.println(ret);
    }
}

