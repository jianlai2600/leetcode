package 最小路径和;

class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < m; j++){
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }
        for (int i = 1; i < n; i++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        Solution sol = new Solution();
        int ret = sol.minPathSum(grid);

        System.out.println(ret);
    }
}


