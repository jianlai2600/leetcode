package 托普利茨矩阵;

class Solution {
    int m, n;
    public boolean isValid(int[][] matrix, int x, int y) {

        x++;
        y++;
        while (x < m && y < n) {
            if (matrix[x][y] != matrix[x - 1][y - 1]) {
                return false;
            }
            x++;
            y++;
        }
        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (!isValid(matrix, 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < m; i++) {
            if (!isValid(matrix, i, 0)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[][]matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};

        Solution sol = new Solution();
        boolean ret = sol.isToeplitzMatrix(matrix);

        System.out.println(ret);
    }
}