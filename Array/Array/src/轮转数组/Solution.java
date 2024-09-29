package 轮转数组;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public void reverse(int[]nums, int left, int right) {

        while (left <= right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public static void main(String[] args) {

        int[]nums = {1,2,3,4,5,6,7};
        int k = 3;

        Solution sol = new Solution();
        sol.rotate(nums, k);

        for (Integer item : nums){
            System.out.print(item + "->");
        }
        System.out.println();
    }
}