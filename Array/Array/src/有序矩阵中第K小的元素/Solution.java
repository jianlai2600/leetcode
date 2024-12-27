package 有序矩阵中第K小的元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int n;
    public boolean check(int[][]matrix, int mid, int k) {

        int i = n - 1, j = 0;

        int cnt = 0;
        while (i >= 0 && j <= n - 1) {
            while (i >= 0 && matrix[i][j] > mid) {
                i--;
            }
            cnt += i + 1;
            i = n - 1;
            j++;
        }
        return cnt >= k;
    }
    public int kthSmallest(int[][] matrix, int k) {

        n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        Solution sol = new Solution();
        int res = sol.kthSmallest(matrix, k);

        System.out.println(res);
    }
}