package 判断子序列;

class Solution {
    public boolean isSubsequence(String s, String t) {

        int m = s.length(), n = t.length();
        int[][]dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n] == s.length();
    }
    public static void main(String[] args)
    {
        String s = "b", t = "abc";

        Solution sol = new Solution();
        boolean ret = sol.isSubsequence(s, t);

        System.out.println(ret);
    }
}


