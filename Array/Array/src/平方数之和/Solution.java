package 平方数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean judgeSquareSum(int c) {

        if (c == 0) {
            return true;
        }
        for (int i = 1; i <= Math.sqrt(c); i++) {
            int pow = i * i;
            int remain = c - pow;

            double sq = Math.sqrt(remain);

            if (sq ==(int)sq) {
                return true;
            }
        }
        return false;
    }
    public boolean judgeSquareSum2(int c) {

        long left = 0, right = (long)Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int c = 5;

        Solution sol = new Solution();
        boolean res = sol.judgeSquareSum(c);

        System.out.println(res);
    }
}