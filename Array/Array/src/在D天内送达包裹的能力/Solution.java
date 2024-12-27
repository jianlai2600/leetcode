package 在D天内送达包裹的能力;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int getDay(int[] weights, int carry) {

        int cnt = 0;
        int curSum = 0;
        for (int i = 0; i < weights.length; i++) {
            curSum += weights[i];
            if (curSum > carry) {
                cnt++;
                curSum = weights[i];
            }
        }
        return ++cnt;
    }
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }

        int mid = 0;
        int res = right;

        while (left < right) {
            mid = left + (right - left) / 2;
            int day = getDay(weights, mid);
            if (day > days) {
                left = mid + 1;
            } else if (day <= days) {
                res = Math.min(res, mid);
                right = mid;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] weights = {10,50,100,100,50,100,100,100};
        int days = 5;

        Solution sol = new Solution();
        int ret = sol.shipWithinDays(weights, days);

        System.out.println(ret);
    }
}