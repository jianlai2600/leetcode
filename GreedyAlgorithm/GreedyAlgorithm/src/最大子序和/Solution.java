package 最大子序和;

import java.util.Arrays;
import java.util.Map;

class Solution {

    public int maxSubArray(int[] nums) {

        int m = nums.length, ret = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < m; i++) {
            sum += nums[i];
            ret = Math.max(ret, sum);
            sum = Math.max(0, sum);
        }

        return ret;
    }
    
    public static void main(String[] args) {

        int[] nums = {-1};

        Solution sol = new Solution();
        int ret = sol.maxSubArray(nums);

        System.out.println(ret);
    }
}

