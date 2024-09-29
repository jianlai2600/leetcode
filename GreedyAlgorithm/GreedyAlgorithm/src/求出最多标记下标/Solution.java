package 求出最多标记下标;

import java.util.Arrays;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int ret = 0, n = nums.length, mid = n / 2;
        int left = 0, right = n / 2;

        while (left < mid && right < n) {
            if (nums[left] * 2 <= nums[right]) {
                left++;
                right++;
                ret++;
            } else {
                right++;
            }
        }

        return ret * 2;
    }
    public static void main(String[] args) {

        int[]num = {42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40};

        Solution sol = new Solution();
        int ret = sol.maxNumOfMarkedIndices(num);

        System.out.println(ret);
    }
}