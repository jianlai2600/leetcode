package 坏了的计算器;

import java.util.*;

class Solution {
    public int brokenCalc(int startValue, int target) {

        int cnt = 0;
        while (target > startValue) {
            if (target % 2 == 1) {
                target += 1;
                cnt++;
            } else {
                target /= 2;
                cnt++;
            }
        }
        return cnt + startValue - target;
    }
    public static void main(String[] args) {

        int startValue = 3, target = 10;

        Solution sol = new Solution();
        int res = sol.brokenCalc(startValue, target);

        System.out.println(res);
    }
}