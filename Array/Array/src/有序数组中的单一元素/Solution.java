package 有序数组中的单一元素;

import java.util.Arrays;

class Solution {
    public int singleNonDuplicate(int[] nums) {

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,2,3,3,4,4,8,8};

        Solution sol = new Solution();
        int ret = sol.singleNonDuplicate(nums);

        System.out.println(ret);
    }
}