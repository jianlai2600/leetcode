package 判断是否可以赢得数字游戏;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean canAliceWin(int[] nums) {

        int sum1 = 0, sum2 = 0;

        for (Integer num : nums) {
            if (num >= 1 && num <= 9) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        return sum1 > sum2 || sum2 > sum1;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,14};

        Solution sol = new Solution();
        boolean ret = sol.canAliceWin(nums);

        System.out.println(ret);
    }
}