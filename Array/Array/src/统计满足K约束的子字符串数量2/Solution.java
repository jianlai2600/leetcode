package 统计满足K约束的子字符串数量1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countKConstraintSubstrings(String s, int k) {

        int n = s.length();
        int[]preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + s.charAt(i) - '0';
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int oneNum = preSum[j + 1] - preSum[i];
                int zeroNum = j - i + 1 - oneNum;

                if (oneNum <= k || zeroNum <= k) {
                    cnt++;
                } else {
                    break;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        String s = "10101";
        int k = 1;

        Solution sol = new Solution();
        int ret = sol.countKConstraintSubstrings(s, k);

        System.out.println(ret);
    }
}