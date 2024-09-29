package 飞地的数量;


class Solution {
    // DFS
    public void dfs(int[][]grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
    }
    public int numEnclaves(int[][] grid) {

        int ret = 0;
        int m = grid.length, n = grid[0].length;

        for (int j = 0; j < n; j++) {
             dfs(grid, 0, j);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ret++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        Solution sol = new Solution();
        int ret = sol.numEnclaves(grid);

        System.out.println(ret);
    }
}


