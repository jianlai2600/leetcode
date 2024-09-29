package 插入区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]>ret = new ArrayList<>();
        int n = intervals.length;
        int index = 0;

        while (index < n && intervals[index][1] < newInterval[0]) {
            ret.add(intervals[index++]);
        }

        int curLeft = newInterval[0], curRight = newInterval[1];
        while (index < n && intervals[index][0] <= curRight) {
            curLeft = Math.min(curLeft, intervals[index][0]);
            curRight = Math.max(curRight, intervals[index][1]);
            index++;
        }
        ret.add(new int[]{curLeft, curRight});

        while (index < n) {
            ret.add(intervals[index++]);
        }

        return ret.toArray(new int[ret.size()][]);
    }
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        Solution sol = new Solution();
        int[][]ret = sol.insert(intervals, newInterval);

        for (int[]interval : ret) {
            for (Integer num : interval) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}