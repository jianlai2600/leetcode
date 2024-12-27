package 最少翻转次数使二进制矩阵回文2;

class Solution {
    public int minFlips(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int res = 0;

        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {

                int one = 0;
                if (grid[i][j] == 1) {
                    one++;
                }
                if (grid[i][n - j - 1] == 1) {
                    one++;
                }
                if (grid[m - i - 1][j] == 1) {
                    one++;
                }
                if (grid[m - i - 1][n - j - 1] == 1) {
                    one++;
                }
                res += Math.min(one, 4 - one);
            }
        }

        int same = 0;
        int diff = 0;

        if (m % 2 == 1) {

            int i = m / 2;
            for (int j = 0; j < n / 2; j++) {
                if (grid[i][j] == grid[i][n - j - 1]) {
                    if (grid[i][j] == 1) {
                        same++;
                    }
                } else {
                    diff++;
                }
            }
        }

        if (n % 2 == 1) {

            int j = n / 2;
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][j] == grid[m - i - 1][j]) {
                    if (grid[i][j] == 1) {
                        same++;
                    }
                } else {
                    diff++;
                }
            }
        }

        if (same % 2 == 1) {
            if (diff == 0) {
                res += 2;
            }
        }
        res += diff;

        if (m % 2 == 1 && n % 2 == 1 && grid[m / 2][n / 2] == 1) {
            res++;
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] grid = {
                {0, 0, 1},
                {0, 0, 1},
                {1, 0, 1},
                {1, 0, 0},
                {0, 1, 1}
        };

        Solution sol = new Solution();
        int ret = sol.minFlips(grid);

        System.out.println(ret);
    }
}


