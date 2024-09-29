package 沉没孤岛;

class Solution {
    // DFS
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(int[][] grid, int x, int y) {

        grid[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                dfs(grid, nx, ny);
            }
        }
    }
    public void sinkIsland(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                } else if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        Solution sol = new Solution();
        sol.sinkIsland(grid);

        for (int[]row : grid) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}


