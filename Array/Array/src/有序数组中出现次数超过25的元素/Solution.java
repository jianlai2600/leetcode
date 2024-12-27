package 有序数组中出现次数超过25的元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findSpecialInteger(int[] arr) {

        int n = arr.length;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > n / 4) {
                return arr[i];
            }
        }
        return arr[n - 1];
    }
    public static void main(String[] args) {

        int[]arr = {1,2,2,6,6,6,6,7,10};

        Solution sol = new Solution();
        int ret = sol.findSpecialInteger(arr);

        System.out.println(ret);
    }
}