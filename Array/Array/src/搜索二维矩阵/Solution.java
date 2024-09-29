package 搜索二维矩阵;

class Solution {
    public boolean binarySearch(int[][]matrix, int target, int index) {

        int[]arr = matrix[index];
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        while (up <= down) {
            int mid = (up + down) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                return binarySearch(matrix, target, mid);
            } else if (target < matrix[mid][0]) {
                down = mid - 1;
            } else {
                up = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int[][] matrix = {
                {1}
        };

        int target = 1;

        Solution sol = new Solution();
        boolean ret = sol.searchMatrix(matrix, target);

        System.out.println(ret);
    }
}