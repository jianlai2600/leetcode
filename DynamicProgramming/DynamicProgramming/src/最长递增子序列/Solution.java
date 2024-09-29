package 最长递增子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int[]dp = new int[n];

        Arrays.fill(dp, 1);

        int ret = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                ret = Math.max(ret, dp[i]);
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,6,7,9,4,10,5,6};

        Solution sol = new Solution();
        int ret = sol.lengthOfLIS(nums);

        System.out.println(ret);
    }
}


