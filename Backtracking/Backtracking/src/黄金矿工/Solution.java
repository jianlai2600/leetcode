package 黄金矿工;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][]directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int ans = 0;
    public void backTracking(int x, int y, int curSum, boolean[][]visited, int[][] grid) {

        ans = Math.max(ans, curSum);

        for (int i = 0; i < 4; i++) {
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                if (!visited[nextX][nextY] && grid[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true;
                    curSum += grid[nextX][nextY];
                    backTracking(nextX, nextY, curSum, visited, grid);
                    visited[nextX][nextY] = false;
                    curSum -= grid[nextX][nextY];
                }

            }

        }
    }
    public int getMaximumGold(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][]visited = new boolean[m][n];
                    visited[i][j] = true;
                    int curSum = grid[i][j];
                    backTracking(i, j, curSum, visited, grid);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };

        Solution sol = new Solution();
        int ret = sol.getMaximumGold(grid);

        System.out.println(ret);
    }
}