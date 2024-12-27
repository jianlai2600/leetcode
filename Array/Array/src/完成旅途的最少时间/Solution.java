package 完成旅途的最少时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long getHour(int[]time, long hour) {

        long res = 0;

        for (Integer t : time) {

            res += hour / t;
        }
        return res;
    }
    public long minimumTime(int[] time, int totalTrips) {

        Arrays.sort(time);
        int n = time.length;

        long left = 1, right = (long) totalTrips * time[n - 1];

        while (left < right) {
            long mid = left + (right - left) / 2;
            long trips = getHour(time, mid);

            if (trips < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
    public static void main(String[] args) {

        int[] times = {10000};
        int totalTrips = 10000000;

        Solution sol = new Solution();
        long ret = sol.minimumTime(times, totalTrips);

        System.out.println(ret);
    }
}