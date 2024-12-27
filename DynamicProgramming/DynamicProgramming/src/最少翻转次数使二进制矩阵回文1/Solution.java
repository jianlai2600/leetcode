package 最少翻转次数使二进制矩阵回文1;

class Solution {
    public int minFlips(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int row = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (grid[i][j] != grid[i][n - j - 1]) {
                    row++;
                }
            }
        }

        int col = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][j] != grid[m - i - 1][j]) {
                    col++;
                }
            }
        }
        return Math.min(row, col);
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        Solution sol = new Solution();
        int ret = sol.minFlips(grid);

        System.out.println(ret);
    }
}


