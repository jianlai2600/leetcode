package 执行操作可获得的最大总奖励1;

import java.util.Arrays;

class Solution {

    public int maxTotalReward(int[] rewardValues) {

        Arrays.sort(rewardValues);
        int n = rewardValues.length;

        int maxValue = rewardValues[n - 1];
        int[]dp = new int[2 * maxValue];

        dp[0] = 1;

        for (Integer reward : rewardValues) {
            for (int i = 2 * reward - 1; i >= reward ; i--) {
                if (dp[i - reward] == 1) {
                    dp[i] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 2 * maxValue - 1; i >= 0; i--) {
            if (dp[i] == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] rewardValues = {1,6,4,3,2};

        Solution sol = new Solution();
        int res = sol.maxTotalReward(rewardValues);

        System.out.println(res);
    }
}


