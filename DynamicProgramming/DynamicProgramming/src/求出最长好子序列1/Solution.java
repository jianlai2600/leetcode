package 求出最长好子序列1;

import java.util.Arrays;

class Solution {
    public int maximumLength(int[] nums, int k) {

        int ret = 1, n = nums.length;
        int[][]dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int p = 0; p < i; p++) {
                    if (nums[p] == nums[i]) {
                        dp[i][j] = Math.max(dp[p][j] + 1, dp[i][j]);
                    } else if (j >= 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j - 1] + 1);
                    }
                }
            }
            ret = Math.max(ret, dp[i][k]);
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {1,2,1,1,3};
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.maximumLength(nums, k);

        System.out.println(ret);
    }
}


