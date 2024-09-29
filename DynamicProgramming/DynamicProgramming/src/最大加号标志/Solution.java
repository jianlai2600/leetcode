package 最大加号标志;

import java.util.Arrays;

class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int ret = 0;

        int[][]matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 1);
        }

        for (int[]point : mines) {
            matrix[point[0]][point[1]] = 0;
        }

        int[][][]dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j][0] = j == 0 ? 1 : dp[i][j - 1][0] + 1;
                    dp[i][j][1] = i == 0 ? 1 : dp[i - 1][j][1] + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    dp[i][j][2] = j == n - 1 ? 1 : dp[i][j + 1][2] + 1;
                    dp[i][j][3] = i == n - 1 ? 1 : dp[i + 1][j][3] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curMin = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    curMin = Math.min(curMin, dp[i][j][k]);
                }
                ret = Math.max(ret, curMin);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int n = 5;
        int[][]mines = {{4, 2}};

        Solution sol = new Solution();
        int ret = sol.orderOfLargestPlusSign(n, mines);

        System.out.println(ret);
    }
}


