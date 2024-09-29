package 最大人工岛;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    // DFS
    int[][]directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    Map<Integer, Integer>map;
    public int dfs(int[][]grid, int x, int y, int islandNum) {

        int ret = 1;
        grid[x][y] = islandNum;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 1) {
                ret += dfs(grid, nx, ny, islandNum);
            }
        }
        return ret;
    }
    public int largestIsland(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        map = new HashMap<>();
        map.put(0, 0);

        boolean allOne = true;
        // Mark island
        int islandNum = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (allOne && grid[i][j] == 0) {
                    allOne = false;
                }
                if (grid[i][j] == 1) {
                    int num = dfs(grid, i, j, islandNum);
                    map.put(islandNum, num);
                    islandNum++;
                }
            }
        }

        if (allOne) {
            return m * n;
        }
        // traversal every 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer>set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + directions[k][0];
                        int ny = j + directions[k][1];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        int islandIndex = grid[nx][ny];
                        if (!set.contains(islandIndex)) {
                            area += map.get(islandIndex);
                            set.add(islandIndex);
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1},
                {1, 1}
        };

        Solution sol = new Solution();
        int ret = sol.largestIsland(grid);

        System.out.println(ret);
    }
}


