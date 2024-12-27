package 两数之和2输入有序数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int binarySearch(int[]numbers, int target, int start) {

        int left = start, right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {

        int[]res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            int need = target - numbers[i];

            int index = binarySearch(numbers, need, i + 1);
            if (index != -1) {
                res[0] = i + 1;
                res[1] = index + 1;
                return res;
            }
        }

        return res;
    }
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        Solution sol = new Solution();
        int[] ret = sol.twoSum(nums, target);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}



