package 石子游戏;

class Solution {
    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int[][]dp = new int[n][n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
            sum += piles[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    dp[i][j] = Math.max(piles[i], piles[j]);
                } else {
                    int takeLeft = piles[i] + dp[i + 1][j];
                    int takeRight = piles[j] + dp[i][j - 1];

                    dp[i][j] = Math.max(takeLeft, takeRight);
                }
            }
        }
        return dp[0][n - 1] > sum - dp[0][n - 1];
    }
    public static void main(String[] args) {

        int[]piles = {5,3,4,5};

        Solution sol = new Solution();
        boolean ret = sol.stoneGame(piles);

        System.out.println(ret);
    }
}


