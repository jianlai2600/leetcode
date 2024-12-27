package 子数组范围和;

class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;
        long res = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = i, right = i;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            while (right < n) {

                if (nums[right] > max) {
                    max = nums[right];
                }
                if (nums[right] < min) {
                    min = nums[right];
                }
                res += max - min;
                right++;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {4,-2,-3,4,1};

        Solution sol = new Solution();
        long res = sol.subArrayRanges(nums);

        System.out.println(res);
    }
}