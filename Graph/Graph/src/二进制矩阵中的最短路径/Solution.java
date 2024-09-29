package 二进制矩阵中的最短路径;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int ret = Integer.MAX_VALUE;
    int m, n;
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    // BFS
    public void bfs(int[][]grid, int x, int y) {

        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                int[]tmp = queue.poll();
                x = tmp[0];
                y = tmp[1];

                if (grid[x][y] == 1) {
                    continue;
                }
                if (x == m - 1 && y == n - 1) {
                    ret = Math.min(ret, dist);
                }

                grid[x][y] = 1;

                for (int i = 0; i < 8; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    queue.add(new int[]{nx, ny});
                }
            }

        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        bfs(grid, 0, 0);

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
    public static void main(String[] args) {

        int grid[][] = {{0, 0, 0},
                        {1, 1, 0},
                        {1, 1, 1}};

        Solution sol = new Solution();
        int ret = sol.shortestPathBinaryMatrix(grid);

        System.out.println(ret);
    }
}


