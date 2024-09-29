
package 两个线段获得的最多奖品;

import java.util.Arrays;

class Solution {
    public int search(int[]arr, int target) {

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int maximizeWin(int[] prizePositions, int k) {

        int ret = 0;
        int n = prizePositions.length;
        int[]dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = prizePositions[i - 1];
            int j = search(prizePositions, num - k);
            ret = Math.max(ret, dp[j] + i - j);
            dp[i] = Math.max(dp[i - 1], i - j);
        }

        return ret;
    }

    public static void main(String[] args) {

        int[]prizePositions = {1,1,2,2,3,3,5};
        int k = 2;

        Solution sol = new Solution();
        int ret = sol.maximizeWin(prizePositions, k);

        System.out.println(ret);
    }
}