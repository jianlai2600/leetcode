package 多数元素;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public static void main(String[] args)
    {
        int[] nums = {3,2,3};

        Solution sol = new Solution();
        int ret = sol.majorityElement(nums);

        System.out.println(ret);
    }
}



