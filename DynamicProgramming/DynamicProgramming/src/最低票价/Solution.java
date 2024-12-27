package 最低票价;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days[days.length - 1];
        int[]dp = new int[n + 1];
        int index = 0;

        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == days[index]) {
                dp[i] = Math.min(Math.min(dp[Math.max(i - 1, 0)] + costs[0], dp[Math.max(i - 7, 0)] + costs[1]), dp[Math.max(i - 30, 0)] + costs[2]);
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int[]days = {6,8,9,18,20,21,23,25}, costs = {2, 10, 41};

        Solution sol = new Solution();
        int ret = sol.mincostTickets(days, costs);

        System.out.println(ret);
    }
}


