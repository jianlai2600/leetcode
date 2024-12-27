package 按符号重排数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[pos] = nums[i];
                pos += 2;
            } else {
                res[neg] = nums[i];
                neg += 2;
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[] nums = {3,1,-2,-5,2,-4};

        Solution sol = new Solution();
        int[]ret = sol.rearrangeArray(nums);

        System.out.println(Arrays.toString(ret));
    }
}