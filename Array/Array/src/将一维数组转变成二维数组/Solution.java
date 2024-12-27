package 将一维数组转变成二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[index++];
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        Solution sol = new Solution();
        int[][]res = sol.construct2DArray(nums, 2, 2);

        System.out.println(Arrays.deepToString(res));
    }
}