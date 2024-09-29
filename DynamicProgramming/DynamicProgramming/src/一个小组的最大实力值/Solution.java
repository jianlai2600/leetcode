package 一个小组的最大实力值;

import java.util.Arrays;

class Solution {
    public long maxStrength(int[] nums) {

        Arrays.sort(nums);

        long ret = 0;
        int ind = -1;
        int posNum = 0, negNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (ret == 0) {
                    ret = nums[i];
                } else {
                    ret *= nums[i];
                }
                if (nums[i] > 0) {
                    posNum++;
                } else {
                    negNum++;
                    ind = i;
                }
            }
        }
        if (nums.length == 1 && nums[0] < 0) {
            return nums[0];
        }
        if (posNum == 0 && negNum <= 1) {
            return 0;
        }
        if (negNum % 2 == 1) {
            ret /= nums[ind];
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {2, -1};

        Solution sol = new Solution();
        long ret = sol.maxStrength(nums);

        System.out.println(ret);
    }
}


