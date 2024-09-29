package 组合总和4;

class Solution {
    /**
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     * @param nums
     * @param target
     * @return
     */
    // 组 外 物
    // 排 内 物
    public int combinationSum4(int[] nums, int target) {

        int[]dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++){
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;

        Solution sol = new Solution();
        int ret = sol.combinationSum4(nums, target);

        System.out.println(ret);
    }
}


