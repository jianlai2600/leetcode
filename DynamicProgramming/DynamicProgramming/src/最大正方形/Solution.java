package 最大正方形;

class Solution {
    public boolean have(int i, int j, int len, int[][]preSum) {

        int sum = 0;
        int x = i + len - 1;
        int y = j + len - 1;

        sum = preSum[x + 1][y + 1] + preSum[i][j] - preSum[x + 1][j] - preSum[i][y + 1];
        return sum == len * len;
    }
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int len = Math.min(m, n);

        int[][]preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
                preSum[i + 1][j + 1] += matrix[i][j] == '1' ? 1 : 0;
            }
        }

        for (int l = 1; l <= len; l++) {
            outer:
            for (int i = 0; i <= m - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    if (have(i, j, l, preSum)) {
                        res = Math.max(res, l);
                        break outer;
                    }
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        Solution sol = new Solution();
        int ret = sol.maximalSquare(matrix);

        System.out.println(ret);
    }
}


