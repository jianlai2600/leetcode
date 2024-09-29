package 元素和小于等于阈值的正方形的最大边长;

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length, n = mat[0].length;
        int res = 0;
        //
        int[][]preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += mat[i][j];
                preSum[i + 1][j + 1] = preSum[i][j + 1] + rowSum;
            }
        }
        //
        int upperBound = Math.min(m, n);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= upperBound; k++) {
                    if (i + k - 1 > m || j + k - 1 > n) {
                        continue;
                    }
                    if (preSum[i + k - 1][j + k - 1] - preSum[i + k - 1][j - 1] - preSum[i - 1][j + k - 1] + preSum[i - 1][j - 1] <= threshold) {
                        res = Math.max(res, k);
                    }
                }
            }
        }
        //
        return res;
    }
    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2}
        };

        int threshold = 4;

        Solution sol = new Solution();
        int ret = sol.maxSideLength(mat, threshold);

        System.out.println(ret);
    }
}