package 整数拆分;

class Solution {
    public int integerBreak(int n) {

        int[]dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * dp[i - j]), j * (i - j));
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {

        int n = 10;

        Solution sol = new Solution();
        int ret = sol.integerBreak(n);

        System.out.println(ret);
    }
}


