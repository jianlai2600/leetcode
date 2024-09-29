package 乘积最大子数组;

import java.util.Arrays;
class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int[]maxArray = new int[n];
        int[]minArray = new int[n];
        System.arraycopy(nums, 0, maxArray, 0, n);
        System.arraycopy(nums, 0, minArray, 0, n);

        for (int i = 1; i < n; i++){
            maxArray[i] = Math.max(nums[i], Math.max(nums[i] * maxArray[i - 1], nums[i] * minArray[i - 1]));
            minArray[i] = Math.min(nums[i], Math.min(nums[i] * maxArray[i - 1], nums[i] * minArray[i - 1]));
        }
        int ret = maxArray[0];
        for (int i = 0; i < n; i++){
            ret = Math.max(ret, maxArray[i]);
        }
        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,3,-2,4};

        Solution sol = new Solution();
        int ret = sol.maxProduct(nums);

        System.out.println(ret);
    }
}


