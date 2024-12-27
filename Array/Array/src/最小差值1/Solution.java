package 最小差值1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int max = nums[n - 1];
        int min = nums[0];

        return Math.max(0, max - min - 2 * k);
    }
    public static void main(String[] args) {

        int[] nums = {0, 10};
        int k = 2;

        Solution sol = new Solution();
        int res = sol.smallestRangeI(nums, k);

        System.out.println(res);
    }
}