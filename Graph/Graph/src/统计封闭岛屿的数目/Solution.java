package 统计封闭岛屿的数目;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int m, n;
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void bfs(int[][]grid, int x, int y) {

        grid[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                isClosedIsland = false;
                continue;
            }
            if (grid[nx][ny] == 0) {
                bfs(grid, nx, ny);
            }
        }
    }
    boolean isClosedIsland = true;

    public int closedIsland(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    isClosedIsland = true;
                    bfs(grid, i, j);
                    if (isClosedIsland) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        Solution sol = new Solution();
        int ret = sol.closedIsland(grid);

        System.out.println(ret);
    }
}


