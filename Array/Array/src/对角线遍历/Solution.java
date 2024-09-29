package 对角线遍历;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int m, n;
    public List<Integer> traversal(int[][] mat, int x, int y) {

        List<Integer>ret = new ArrayList<>();
        while (x < m && y >= 0) {
            ret.add(mat[x++][y--]);
        }

        return ret;
    }
    public int[] findDiagonalOrder(int[][] mat) {

        m = mat.length;
        n = mat[0].length;
        int[]ret = new int[n * m];
        int index = 0;
        boolean naturalOrder = false;

        for (int i = 0; i < n; i++) {
            List<Integer>tmp = traversal(mat, 0, i);
            if (naturalOrder) {
                for (Integer num : tmp) {
                    ret[index++] = num;
                }
                naturalOrder = false;
            } else {
                for (Integer num : tmp.reversed()) {
                    ret[index++] = num;
                }
                naturalOrder = true;
            }
        }
        for (int i = 1; i < m; i++) {
            List<Integer>tmp = traversal(mat, i, n - 1);
            if (naturalOrder) {
                for (Integer num : tmp) {
                    ret[index++] = num;
                }
                naturalOrder = false;
            } else {
                for (Integer num : tmp.reversed()) {
                    ret[index++] = num;
                }
                naturalOrder = true;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};

        Solution sol = new Solution();
        int[]ret = sol.findDiagonalOrder(matrix);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}