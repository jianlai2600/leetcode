package 分割字符频率相等的最少子字符串;

import java.util.Arrays;

class Solution {
    public boolean isBalance(int[]alpha) {

        int target = 0;

        for (Integer num : alpha) {
            if (num != 0) {
                target = num;
                break;
            }
        }
        for (Integer num : alpha) {
            if (num != 0 && num != target) {
                return false;
            }
        }
        return true;
    }
    public int minimumSubstringsInPartition(String s) {

        int n = s.length();
        int[]dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            int[]alpha = new int[26];
            for (int j = i; j < n; j++) {
                alpha[s.charAt(j) - 'a']++;
                if (isBalance(alpha) && dp[i] != Integer.MAX_VALUE) {
                    dp[j + 1] = Math.min(dp[i] + 1, dp[j + 1]);
                }
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {

        String s = "fabccddg";

        Solution sol = new Solution();
        int ret = sol.minimumSubstringsInPartition(s);

        System.out.println(ret);
    }
}


