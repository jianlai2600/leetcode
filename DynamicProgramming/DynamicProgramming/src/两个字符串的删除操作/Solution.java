package 两个字符串的删除操作;
class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        int[][]dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int len = dp[m][n];

        return m + n - 2 * len;
    }
    public static void main(String[] args)
    {
        String word1 = "sea";
        String word2 = "eat";

        Solution sol = new Solution();
        int ret = sol.minDistance(word1, word2);

        System.out.println(ret);
    }
}


