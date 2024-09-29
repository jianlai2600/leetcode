package 打家劫舍2;

class Solution {
    public int helper(int[]nums, int start, int end) {

        int len = end - start + 1;
        if (len == 1) {
            return nums[start];
        }
        int[]dp = new int[len];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[len - 1];
    }
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int val1 = helper(nums, 1, n - 1);
        int val2 = helper(nums, 0, n - 2);
        int val3 = helper(nums, 1, n - 2);

        return Math.max(val1, Math.max(val2, val3));
    }

    public static void main(String[] args) {

        int[] nums = {0, 0};

        Solution sol = new Solution();
        int ret = sol.rob(nums);

        System.out.println(ret);
    }
}


