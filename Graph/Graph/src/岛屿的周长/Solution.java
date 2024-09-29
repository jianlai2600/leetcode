package 岛屿的周长;

import java.util.*;

class Solution {
    int[][]directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int checkBoundry(int[][]grid, int x, int y) {

        int ret = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                ret++;
                continue;
            }
            if (grid[nx][ny] == 0) {
                ret++;
            }
        }
        return ret;
    }
    public int islandPerimeter(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int ret = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ret += checkBoundry(grid, i, j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        Solution sol = new Solution();
        int ret = sol.islandPerimeter(grid);

        System.out.println(ret);
    }
}


