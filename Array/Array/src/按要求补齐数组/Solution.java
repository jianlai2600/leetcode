package 按要求补齐数组;

class Solution {
    public int minPatches(int[] nums, int n) {

        int ret = 0;

        int i = 0;
        long range = 0;

        while (range < n) {

            if (i < nums.length && nums[i] <= range + 1) {
                range += nums[i++];
            } else {
                ret++;
                range = 2 * range + 1;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[] nums = {1, 3};
        int n = 6;

        Solution sol = new Solution();
        int ret = sol.minPatches(nums, n);

        System.out.println(ret);
    }
}