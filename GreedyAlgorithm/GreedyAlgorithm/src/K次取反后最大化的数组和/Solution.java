package K次取反后最大化的数组和;

import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
            if (k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        Arrays.sort(nums);

        for (Integer num : nums) {
            ret += num;
        }

        if (k % 2 == 1) {
            ret -= 2 * nums[0];
        }

        return ret;
    }
    
    public static void main(String[] args) {

        int[] nums = {-8,3,-5,-3,-5,-2};
        int k = 6;

        Solution sol = new Solution();
        int ret = sol.largestSumAfterKNegations(nums, k);

        System.out.println(ret);
    }
}

