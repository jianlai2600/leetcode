package 骑士拨号器;

class Solution {
    long MOD = 1000000007;
    public int knightDialer(int n) {

        long[][]dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % MOD;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % MOD;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % MOD;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][9] + dp[i - 1][3]) % MOD;
            dp[i][5] = 0;
            dp[i][6] = (dp[i - 1][1] + dp[i - 1][7] + dp[i - 1][0]) % MOD;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
        }

        long sum = 0;
        for (int j = 0; j < 10; j++) {
            sum = (sum + dp[n][j]) % MOD;
        }
        return (int)sum;
    }
    public static void main(String[] args) {

        int n = 3131;

        Solution sol = new Solution();
        int ret = sol.knightDialer(n);

        System.out.println(ret);
    }
}


