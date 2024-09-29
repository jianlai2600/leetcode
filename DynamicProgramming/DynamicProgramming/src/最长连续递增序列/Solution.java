package 最长连续递增序列;

import java.util.Arrays;

class Solution {

    public int findLengthOfLCIS(int[] nums) {

        int ret = 0, n = nums.length;

        if (n == 1) {
            return 1;
        }

        int[]dp = new int[n];

        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] > ret) {
                ret = dp[i];
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,5,4,7};

        Solution sol = new Solution();
        int ret = sol.findLengthOfLCIS(nums);

        System.out.println(ret);
    }
}


