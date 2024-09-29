package 统计各位数字都不同的数字个数;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }
        int[]dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;

        int ret = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
            ret += dp[i];
        }
        return ret;
    }
    public static void main(String[] args) {

        int n = 3;

        Solution sol = new Solution();
        int ret = sol.countNumbersWithUniqueDigits(n);

        System.out.println(ret);
    }
}


