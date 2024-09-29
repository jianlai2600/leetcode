package 岛屿的最大面积;


import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    // DFS
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int dfs(int[][] grid, int x, int y) {

        grid[x][y] = 0;
        int ret = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                ret += dfs(grid, nx, ny);
            }
        }

        return ret;
    }
    public int maxAreaOfIsland(int[][] grid) {

        int ret = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int tmp = dfs(grid, i, j);
                    ret = Math.max(ret, tmp);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        Solution sol = new Solution();
        int ret = sol.maxAreaOfIsland(grid);

        System.out.println(ret);
    }
}


