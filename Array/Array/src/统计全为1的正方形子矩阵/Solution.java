package 统计全为1的正方形子矩阵;

class Solution {
    public int countSquares(int[][] matrix) {

        int res = 0;

        int m = matrix.length, n = matrix[0].length;
        int maxLen = Math.max(m, n);

        int[][]preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    res++;
                }
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j];
            }
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 0; i <= m - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    int sum = preSum[i + len][j + len] + preSum[i][j] - preSum[i + len][j] - preSum[i][j + len];
                    if (sum == len * len) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        Solution sol = new Solution();
        int ret = sol.countSquares(matrix);

        System.out.println(ret);
    }
}