package 搜索二维矩阵;

import javax.xml.stream.events.StartDocument;

class Solution {

    public int findArray(int[][] matrix, int target)
    {
        int low = -1, high = matrix.length - 1;

        while (low < high)
        {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target)low = mid;
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
    public boolean binarySearch(int[][] nums, int target, int low, int high, int array)
    {
        if (low > high)return false;

        int mid = (low + high) / 2;

        if (target > nums[array][mid])
        {
            return binarySearch(nums, target, mid + 1, high, array);
        } else if (target < nums[array][mid])
        {
            return binarySearch(nums, target, low, mid - 1, array);
        } else if (target == nums[array][mid])
        {
            return true;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int array = findArray(matrix, target);

        if (array < 0)return false;

        return binarySearch(matrix, target, 0, matrix[0].length - 1, array);
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        Solution sol = new Solution();
        boolean ret = sol.searchMatrix(matrix, target);

        System.out.println(ret);
    }
}