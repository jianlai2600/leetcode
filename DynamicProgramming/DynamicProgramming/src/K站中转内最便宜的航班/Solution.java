package K站中转内最便宜的航班;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    static int INF = 1000006;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i][k]表示从i点到dst走k步的最少价格
        // dp[i][k]=min(dp[i_next][k-1] + g[i][j])
        int[][]dp = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (int[]flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];

                dp[s][i] = Math.min(dp[s][i], dp[d][i - 1] + cost);
            }
        }

        int res = dp[src][0];
        for (Integer cost : dp[src]) {
            if (cost < res) {
                res = cost;
            }
        }
        if (res > INF) {
            return -1;
        }
        return res;
    }
    public static void main(String[] args) {

        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        Solution sol = new Solution();
        int ret = sol.findCheapestPrice(n, flights, src, dst, k);

        System.out.println(ret);
    }
}


