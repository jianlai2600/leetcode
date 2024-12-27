package 三角形的最大高度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int helper(int num1, int num2) {

        int cnt = 0;
        int curNum = 1;

        while (num1 > 0 || num2 > 0) {

            if (num1 >= curNum) {
                cnt++;
                num1 -= curNum++;
            } else {
                break;
            }

            if (num2 >= curNum) {
                cnt++;
                num2 -= curNum++;
            } else {
                break;
            }
        }
        return cnt;
    }
    public int maxHeightOfTriangle(int red, int blue) {

        return Math.max(helper(red, blue), helper(blue, red));
    }
    public static void main(String[] args) {

        int red = 2, blue = 4;

        Solution sol = new Solution();
        int res = sol.maxHeightOfTriangle(red, blue);

        System.out.println(res);
    }
}