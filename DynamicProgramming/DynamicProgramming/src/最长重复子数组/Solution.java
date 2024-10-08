package 最长重复子数组;

class Solution {

    public int findLength(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;
        int[][]dp = new int[m + 1][n + 1];

        int ret = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > ret) {
                        ret = dp[i][j];
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};

        Solution sol = new Solution();
        int ret = sol.findLength(nums1, nums2);

        System.out.println(ret);
    }
}


