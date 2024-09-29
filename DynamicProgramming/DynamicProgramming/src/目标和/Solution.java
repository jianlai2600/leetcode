package 目标和;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[]dp = new int[bagSize + 1];
        dp[0] = 1;

        // 01背包问题一维dp的遍历，nums放在外循环，target在内循环，且内循环倒序
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                // 只要搞到nums[i]，凑成dp[j]就有dp[j - nums[i]] 种方法
                // 把所有的 dp[j - nums[i]] 累加起来
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }

    public int findTargetSumWays2(int[] nums, int target) {

        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }

        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[]dp = new int[bagSize + 1];

        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int target = 3;

        Solution sol = new Solution();
        int ret = sol.findTargetSumWays2(nums, target);

        System.out.println(ret);
    }
}


