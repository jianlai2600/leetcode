package 数组中的最长山脉;

import java.util.Arrays;

class Solution {
    public int longestMountain(int[] arr) {

        int n = arr.length;
        int res = 0;

        if (n < 3) {
            return 0;
        }

        int[]dp1 = new int[n];
        int[]dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }


        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                int sum = dp1[i] + dp2[i] - 1;
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[]arr = {2,1,4,7,3,2,5};

        Solution sol = new Solution();
        int res = sol.longestMountain(arr);

        System.out.println(res);
    }
}


