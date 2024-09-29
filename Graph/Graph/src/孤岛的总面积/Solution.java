package 孤岛的总面积;


class Solution {
    // DFS
    // 好题 多看
    int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int dfs(int[][] grid, int x, int y) {

        grid[x][y] = 0;
        int ret = 1;

        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                flag = true;
            } else if (grid[nx][ny] == 1) {
                int tmp = dfs(grid, nx, ny);
                if (tmp == 0) {
                    flag = true;
                }
                ret += tmp;
            }
        }
        if (flag) {
            return 0;
        }
        return ret;
    }
    public int sumAreaOfIsolatedIsland(int[][] grid) {

        int ret = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ret += dfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        Solution sol = new Solution();
        int ret = sol.sumAreaOfIsolatedIsland(grid);

        System.out.println(ret);
    }
}


