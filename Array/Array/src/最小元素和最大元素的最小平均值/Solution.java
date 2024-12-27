package 最小元素和最大元素的最小平均值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double minimumAverage(int[] nums) {

        double res = Double.MAX_VALUE;

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right) {
            double tmp = (double)(nums[left] + nums[right]) / 2;

            if (tmp < res) {
                res = tmp;
            }
            left++;
            right--;
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {7,8,3,4,15,13,4,1};

        Solution sol = new Solution();
        double res = sol.minimumAverage(nums);

        System.out.println(res);
    }
}