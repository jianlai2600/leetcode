package 最长递增子序列的个数;

class Solution {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length, ret = 0, maxLen = 0;
        int[]dp = new int[n];
        int[]count = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (maxLen < dp[i]) {
                ret = count[i];
                maxLen = dp[i];
            } else if (maxLen == dp[i]) {
                ret += count[i];
            }

        }
        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,5,4,7};

        Solution sol = new Solution();
        int ret = sol.findNumberOfLIS(nums);

        System.out.println(ret);
    }
}


