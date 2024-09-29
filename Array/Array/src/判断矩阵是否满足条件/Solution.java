package 判断矩阵是否满足条件;

class Solution {
    public boolean satisfiesConditions(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != m - 1 && grid[i + 1][j] != grid[i][j]) {
                    return false;
                }
                if (j != n - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

        int[][] grid = {{1, 0, 2}, {1, 0, 2}};

        Solution sol = new Solution();
        boolean ret = sol.satisfiesConditions(grid);
        System.out.println(ret);
    }
}