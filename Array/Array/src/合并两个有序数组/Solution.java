package 合并两个有序数组;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }
    public static void main(String[] args) {

        int[]nums1 ={2, 0}, nums2 = {1};
        int m = 1, n = 1;

        Solution sol = new Solution();
        sol.merge(nums1, m, nums2, n);

        for (Integer num : nums1) {
            System.out.print(num + "->");
        }
        System.out.println();
    }
}