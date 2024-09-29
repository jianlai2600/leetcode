package 和为K的子数组;

class Solution {
    public int subarraySum(int[] nums, int k) {

        // 前缀和方法，妙
        int ret = 0, n = nums.length;
        int[]preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                if (preSum[right + 1] - preSum[left] == k) {
                    ret++;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {-1, -1, 1};
        int k = 0;

        Solution sol = new Solution();
        int ret = sol.subarraySum(nums, k);

        System.out.println(ret);
    }
}