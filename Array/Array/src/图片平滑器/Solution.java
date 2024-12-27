package 图片平滑器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[]directions = {-1, 0, 1};
    int m, n;
    public int calculate(int[][]img, int x, int y) {

        int cnt = 0;
        int curSum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x + directions[i];
                int ny = y + directions[j];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    cnt++;
                    curSum += img[nx][ny];
                }
            }
        }
        return curSum / cnt;
    }
    public int[][] imageSmoother(int[][] img) {

        m = img.length;
        n = img[0].length;

        int[][]res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = calculate(img, i, j);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[][] matrix = new int[3][3]; // 3 行 3 列
        matrix[0] = new int[]{100, 200, 100};
        matrix[1] = new int[]{200, 50, 200};
        matrix[2] = new int[]{100, 200, 100};

        Solution sol = new Solution();
        int[][]ret = sol.imageSmoother(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}