package 将x减到0的最小操作数;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minOperations(int[] nums, int x) {

        int sum = 0, n = nums.length;
        for (Integer num : nums) {
            sum += num;
        }
        int left = 0, right = 0;

        int len = 0;
        int curSum = 0;
        for (; right < n; right++) {

            curSum += nums[right];
            while (left < right && curSum > sum - x) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == sum - x) {
                len = Math.max(len, right - left + 1);
            }
        }
        if (len == 0 && sum != x) {
            return -1;
        }
        return n - len;
    }
    public static void main(String[] args) {

        int[]nums = {5, 6, 7, 8, 9};
        int x = 4;

        Solution sol = new Solution();
        int ret = sol.minOperations(nums, x);

        System.out.println(ret);
    }
}