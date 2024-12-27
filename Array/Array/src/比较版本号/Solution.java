package 比较版本号;

import java.util.Arrays;

class Solution {
    public int compareVersion(String version1, String version2) {

        String[]arr1 = version1.split("\\.");
        String[]arr2 = version2.split("\\.");

        int len1 = arr1.length;
        int len2 = arr2.length;
        int n = Math.max(len1, len2);

        int num1 = 0, num2 = 0;

        for (int i = 0; i < n; i++) {
            if (i >= len1) {
                num1 = 0;
            } else {
                num1 = Integer.valueOf(arr1[i]);
            }

            if (i >= len2) {
                num2 = 0;
            } else {
                num2 = Integer.valueOf(arr2[i]);
            }

            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        String version1 = "1.2", version2 = "1.10";

        Solution sol = new Solution();
        int res = sol.compareVersion(version1, version2);

        System.out.println(res);
    }
}