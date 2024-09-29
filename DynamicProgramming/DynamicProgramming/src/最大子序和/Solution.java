package 最大子序和;

class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length, ret = nums[0];

        if (n == 1) {
            return nums[0];
        }

        int[]dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

            if (dp[i] > ret) {
                ret = dp[i];
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {-1, -2};

        Solution sol = new Solution();
        int ret = sol.maxSubArray(nums);

        System.out.println(ret);
    }
}


