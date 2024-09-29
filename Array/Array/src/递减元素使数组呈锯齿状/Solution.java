package 递减元素使数组呈锯齿状;

class Solution {
    public int helper(int[]nums, int startIndex) {

        int res = 0;

        int n = nums.length;

        for (int i = startIndex; i < n; i = i + 2) {

            int a = 0;
            if (i >= 1) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < n) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }

        return res;
    }
    public int movesToMakeZigzag(int[] nums) {

        return Math.min(helper(nums, 0), helper(nums, 1));
    }
    public static void main(String[] args) {

        int[] nums = {9,6,1,6,2};

        Solution sol = new Solution();
        int ret = sol.movesToMakeZigzag(nums);

        System.out.println(ret);
    }
}