package 螺旋矩阵3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int num = rows * cols;
        int[][]result = new int[num][2];
        result[0][0] = rStart;
        result[0][1] = cStart;
        int index = 1;

        int len = 2;
        int x = rStart;
        int y = cStart;

        while (index < num) {
            //
            y += 1;
            for (int i = 0; i < len; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
                x += 1;
            }
            x -= 1;
            //
            y -= 1;
            for (int i = 0; i < len; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
                y -= 1;
            }
            y += 1;
            //
            x -= 1;
            for (int i = 0; i < len; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
                x -= 1;
            }
            x += 1;
            //
            y += 1;
            for (int i = 0; i < len; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
                y += 1;
            }
            y -= 1;


            len += 2;
        }

        return result;
    }
    public static void main(String[] args) {

        int rows = 5, cols = 6, rStart = 1, cStart = 4;

        Solution sol = new Solution();
        int[][]result = sol.spiralMatrixIII(rows, cols, rStart, cStart);

        System.out.println(Arrays.deepToString(result));
    }
}