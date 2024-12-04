package 最小差值2;

import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] nums, int k) {

        Arrays.sort(nums);

        int n = nums.length;
        int max = nums[n - 1];
        int min = nums[0];

        int res = max - min;

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(nums[n - 1] - k, nums[i] + k);
            min = Math.min(nums[0] + k, nums[i + 1] - k);

            res = Math.min(res, max - min);
        }
        return res;
    }
    public static void main(String[] args) {

        int[]nums = {1, 3, 6};
        int k = 3;

        Solution sol = new Solution();
        int res = sol.smallestRangeII(nums, k);

        System.out.println(res);
    }
}

