package 找到所有的农场组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[]corner;
    int[][]directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void dfs(int[][] land, int x, int y) {

        land[x][y] = 0;
        corner[0] = Math.max(corner[0], x);
        corner[1] = Math.max(corner[1], y);
        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && land[nx][ny] == 1) {
                dfs(land, nx, ny);
            }
        }
    }
    public int[][] findFarmland(int[][] land) {

        int m = land.length;
        int n = land[0].length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[]tmp = new int[4];
                    tmp[0] = i;
                    tmp[1] = j;
                    corner = new int[2];
                    dfs(land, i, j);
                    tmp[2] = corner[0];
                    tmp[3] = corner[1];
                    list.add(tmp);
                }
            }
        }

        int len = list.size();
        int[][]res = new int[len][4];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        };

        Solution sol = new Solution();
        int[][] ret = sol.findFarmland(mat);

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}