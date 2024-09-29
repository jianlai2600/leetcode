package 岛屿数量;


import java.security.KeyPair;
import java.util.*;

class Solution {
    // DFS
    int ret;
    int m, n;
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][]visited;
    public void dfs(boolean[][]visited, char[][] grid, int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(visited, grid, nx, ny);
            }
        }
    }
    public int numIslands_DFS(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];
        ret = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ret++;
                    visited[i][j] = true;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return ret;
    }
    // BFS
    public void bfs(boolean[][]visited, char[][] grid, int x, int y) {

        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[]tmp = queue.poll();
            x = tmp[0];
            y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    public int numIslands_BFS(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];
        ret = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ret++;
                    visited[i][j] = true;
                    bfs(visited, grid, i, j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        char grid[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};

        Solution sol = new Solution();
        int ret = sol.numIslands_BFS(grid);

        System.out.println(ret);
    }
}


