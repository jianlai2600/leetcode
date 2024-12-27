package 寻找峰值2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[][]direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[] findPeakGrid(int[][] mat) {

        int x = 0, y = 0;

        int m = mat.length, n = mat[0].length;

        while (true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (mat[nx][ny] > mat[x][y]) {
                    flag = false;
                    x = nx;
                    y = ny;
                    break;
                }
            }
            if (flag) {
                return new int[]{x, y};
            }
        }
    }
    public static void main(String[] args) {

        int[][] mat = {
                {1, 4},
                {3, 2}
        };

        Solution sol = new Solution();
        int[] ret = sol.findPeakGrid(mat);

        System.out.println(ret[0] + " " + ret[1]);
    }
}