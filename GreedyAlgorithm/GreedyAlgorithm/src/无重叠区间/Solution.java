package 无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int cnt = 0;
        Arrays.sort(intervals, (a, b)->{
            return a[0] - b[0];
        });

        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                cnt++;
                if (intervals[i][1] < right) {
                    right = intervals[i][1];
                }
            } else {
                right = intervals[i][1];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};

        Solution sol = new Solution();
        int ret = sol.eraseOverlapIntervals(intervals);

        System.out.println(ret);
    }
}

