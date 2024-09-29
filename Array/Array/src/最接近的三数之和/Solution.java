package 最接近的三数之和;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int ret = 0;
        int n = nums.length, minAbs = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int curAbs = Math.abs(target - sum);
                if (curAbs < minAbs) {
                    ret = sum;
                    minAbs = curAbs;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]nums = {-1,2,1,-4};
        int target = 1;

        Solution sol = new Solution();
        int ret = sol.threeSumClosest(nums, target);

        System.out.println(ret);
    }
}