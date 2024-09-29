package 有效的山脉数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean validMountainArray(int[] arr) {

        int n = arr.length;

        if (n < 3) {
            return false;
        }

        int changePoint = -1;

        for (int i = 1; i < n; i++) {
            if (changePoint == -1 && arr[i] > arr[i - 1]) {
                continue;
            } else if (changePoint == -1 && arr[i] < arr[i - 1]) {
                changePoint = i - 1;
            } else if (changePoint != -1 && arr[i] < arr[i - 1]) {
                continue;
            } else {
                return false;
            }
        }

        if (changePoint == 0 || changePoint == n - 1 || changePoint == -1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {9,8,7,6,5,4,3,2,1,0};

        Solution sol = new Solution();
        boolean ret = sol.validMountainArray(nums);

        System.out.println(ret);
    }
}