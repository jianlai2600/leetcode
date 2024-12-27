package 准时到达的列车最小时速;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double getHour(int[]dist, int v) {
        double res = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            res += Math.ceil((double)dist[i] / (double) v);
        }
        res += (double)dist[dist.length - 1] / (double) v;
        return res;
    }
    public int minSpeedOnTime(int[] dist, double hour) {

        int n = dist.length;

        if (n > Math.ceil(hour)) {
            return -1;
        }

        int left = 1, right = 10000000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            double h = getHour(dist, mid);
            if (h <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static void main(String[] args) {

        int[] dist = {1,1,100000};
        double hour = 2.01;

        Solution sol = new Solution();
        int ret = sol.minSpeedOnTime(dist, hour);

        System.out.println(ret);
    }
}