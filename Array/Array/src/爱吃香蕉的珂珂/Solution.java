package 爱吃香蕉的珂珂;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int getHours(int[]piles, int v) {
        int hours = 0;
        for (Integer pile : piles) {
            hours += (int) Math.ceil((double) pile / v);
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int res = Integer.MAX_VALUE;
        int maxNum = 0;

        for (Integer pile : piles) {
            if (pile > maxNum) {
                maxNum = pile;
            }
        }
        //
        int left = 1, right = maxNum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = getHours(piles, mid);
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //
        return left;
    }
    public static void main(String[] args) {

        int[] piles = {3,6,7,11};
        int h = 8;

        Solution sol = new Solution();
        int ret = sol.minEatingSpeed(piles, h);

        System.out.println(ret);
    }
}