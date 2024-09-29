package 太平洋大西洋水流问题;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // DFS
    int[][]directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    List<List<Integer>>ret;
    int m, n;
    public void dfs(int[][] heights, boolean[][]visited, int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (heights[nx][ny] >= heights[x][y] && !visited[nx][ny]) {
                dfs(heights, visited, nx, ny);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        ret = new LinkedList<>();

        m = heights.length;
        n = heights[0].length;

        boolean[][]upLeft = new boolean[m][n];
        boolean[][]downRight = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, upLeft, i, 0);
            dfs(heights, downRight, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, upLeft, 0, j);
            dfs(heights, downRight, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (upLeft[i][j] && downRight[i][j]) {
                    List<Integer>tmp = new LinkedList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ret.add(new LinkedList<>(tmp));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1, 1},
                {1, 1},
                {1, 1}
        };

        Solution sol = new Solution();
        List<List<Integer>> ret = sol.pacificAtlantic(heights);

        for (List<Integer> row : ret) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


