package 腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][]directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length, ret = 0;

        Queue<int[]>queue = new LinkedList<>();
        int freshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() && freshOrange == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int ind = 0; ind < size; ind++) {
                int[]tmp = queue.poll();
                int x = tmp[0], y = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshOrange--;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            ret++;
        }
        if (freshOrange != 0) {
            return -1;
        }
        return ret - 1;
    }

    public static void main(String[] args){

        int grid[][] = {{2, 1, 1},{0, 1, 1},{1, 0, 1}};

        Solution sol = new Solution();
        int ret = sol.orangesRotting(grid);

        System.out.println(ret);
    }
}



