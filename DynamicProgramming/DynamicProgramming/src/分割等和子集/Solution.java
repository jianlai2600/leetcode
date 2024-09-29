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

    public static void main(String[] args) {

        int[] nums = {1,2,3,6};

        Solution sol = new Solution();
        boolean ret = sol.canPartition(nums);

        System.out.println(ret);
    }
}


