package 和为目标值的最长子序列的长度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[]dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int m = nums.size();

        int start = 0;
        for (int i = 0; i < m; i++) {
            int num = nums.get(i);
            start = Math.min(start + num, target);
            for (int j = start; j >= num; j--) {
                if (dp[j - num] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - num] + 1);
                }
            }
        }
        return dp[target] > 0 ? dp[target] : -1;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target = 9;

        Solution sol = new Solution();
        int res = sol.lengthOfLongestSubsequence(list, target);

        System.out.println(res);
    }
}


