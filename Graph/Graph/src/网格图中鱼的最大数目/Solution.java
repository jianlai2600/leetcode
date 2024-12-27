package 网格图中鱼的最大数目;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int res;
    int tmp;
    int[][]direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    public void bfs(int[][] grid, int x, int y) {

        tmp += grid[x][y];
        grid[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];

            if (nx < 0 || nx >= m) {
                continue;
            }
            if (ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 0) {
                continue;
            }
            bfs(grid, nx, ny);
        }
    }
    public int findMaxFish(int[][] grid) {

        res = 0;
        tmp = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    tmp = 0;
                    bfs(grid, i, j);
                    if (tmp > res) {
                        res = tmp;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int grid[][] = {{0,2,1,0},
                {4,0,0,3},
                {1,0,0,4},
                {0,3,2,0}};

        Solution sol = new Solution();
        int res = sol.findMaxFish(grid);

        System.out.println(res);
    }
}


