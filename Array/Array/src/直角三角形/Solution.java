package 直角三角形;

class Solution {
    public long numberOfRightTriangles(int[][] grid) {

        long ret = 0;
        int m = grid.length, n = grid[0].length;
        // statistic
        int[]row = new int[m];
        int[]col = new int[n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        // cal
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ret += (long) (row[i] - 1) * (col[j] - 1);
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[][] grid = {{1, 0, 1}, {1, 0, 0}, {1, 0, 0}};

        Solution sol = new Solution();
        long ret = sol.numberOfRightTriangles(grid);

        System.out.println(ret);
    }
}