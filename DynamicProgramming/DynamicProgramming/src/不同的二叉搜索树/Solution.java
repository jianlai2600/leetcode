package 不同的二叉搜索树;

class Solution {

    public int numTrees(int n) {

        int[]dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 4;

        Solution sol = new Solution();
        int ret = sol.numTrees(n);

        System.out.println(ret);
    }
}


