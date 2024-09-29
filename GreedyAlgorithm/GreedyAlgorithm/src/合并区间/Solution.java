package 合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->a[0] - b[0]);

        List<int[]>tmp = new ArrayList<>();

        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int curLeft = intervals[i][0], curRight = intervals[i][1];
            if (curLeft <= right) {
                right = Math.max(right, curRight);
            } else {
                tmp.add(new int[]{left, right});
                left = curLeft;
                right = curRight;
            }
        }
        tmp.add(new int[]{left, right});

        int[][]ret = new int[tmp.size()][2];
        int i = 0;
        for (int[]inter : tmp) {
            ret[i++] = inter;
        }
        return ret;
    }
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Solution sol = new Solution();
        int[][] ret = sol.merge(intervals);

        for (int[] row : ret) {
            for (Integer i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

