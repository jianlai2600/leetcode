package 回文子串;

class Solution {

    public int countSubstrings(String s) {

        int n = s.length(), ret = 0;
        boolean[][]dp = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    ret++;
                } else if (j - i == 1) {
                    if (s.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = true;
                        ret++;
                    }
                } else if (s.charAt(i - 1) == s.charAt(j - 1) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        String s = "aaa";

        Solution sol = new Solution();
        int ret = sol.countSubstrings(s);

        System.out.println(ret);
    }
}


