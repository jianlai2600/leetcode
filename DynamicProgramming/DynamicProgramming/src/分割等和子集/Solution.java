package 分割等和子集;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[]dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    // M2
    public boolean canPartition2(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        int[][]dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(nums, dp, n - 1, target);
    }
    public boolean dfs(int[] nums, int[][]dp, int i, int j) {

        if (i < 0) {
            return j == 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean flag = j >= nums[i] && dfs(nums, dp, i - 1, j - nums[i]) || dfs(nums, dp, i - 1, j);
        dp[i][j] = flag ? 1 : 0;
        return flag;
    }
    // M3
    public boolean canPartition3(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        // 如果总和是奇数，直接返回 false
        if (s % 2 != 0) {
            return false;
        }
        int target = s / 2;
        int n = nums.length;

        boolean[][]dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 返回结果
        return dp[n][target];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,6};

        Solution sol = new Solution();
        boolean ret = sol.canPartition3(nums);

        System.out.println(ret);
    }
}


