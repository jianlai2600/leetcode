package 长度最小的子数组;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int ret = Integer.MAX_VALUE;

        int n = nums.length, sum = 0, left = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                int len = i - left + 1;
                if (len < ret) {
                    ret = len;
                }
                sum -= nums[left++];
            }
        }

        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;

        Solution sol = new Solution();
        int ret = sol.minSubArrayLen(target, nums);

        System.out.println(ret);
    }
}