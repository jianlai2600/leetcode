package 最长回文子序列;

class Solution {
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int[][]dp = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[1][n];
    }
    public static void main(String[] args) {

        String s = "bbbab";

        Solution sol = new Solution();
        int ret = sol.longestPalindromeSubseq(s);

        System.out.println(ret);
    }
}


