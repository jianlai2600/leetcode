package 最短的桥;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    Queue<int[]>queue;
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void makeIsland(int[][]grid, int x, int y) {

        grid[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                grid[nx][ny] = 2;
                makeIsland(grid, nx, ny);
            } else if (grid[nx][ny] == 0) {
                grid[nx][ny] = 2;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
    public int shortestBridge(int[][] grid) {

        int ret = 1;

        queue = new ArrayDeque<>();
        int x = 0, y = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        grid[x][y] = 2;
        makeIsland(grid, x, y);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[]curPoint = queue.poll();
                x = curPoint[0];
                y = curPoint[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + directions[j][0];
                    int ny = y + directions[j][1];

                    if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        return ret;
                    } else if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            ret++;
        }

        return ret;
    }
    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        Solution sol = new Solution();
        int ret = sol.shortestBridge(grid);

        System.out.println(ret);
    }
}


