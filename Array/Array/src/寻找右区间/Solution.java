package 寻找右区间;

import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {

        Map<int[], Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, (a, b)->a[0] - b[0]);

        int n = intervals.length;

        int[]res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < intervals.length; i++) {
            int curIndex = map.get(intervals[i]);
            int nextIndex = i;

            int curRight = intervals[i][1];

            while (nextIndex < intervals.length && intervals[nextIndex][0] < curRight) {
                nextIndex++;
            }
            if (nextIndex != intervals.length) {
                res[curIndex] = map.get(intervals[nextIndex]);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[][] intervals = new int[2][2]; // 初始化一个 3 行 2 列的二维数组
        intervals[0] = new int[]{1, 1};
        intervals[1] = new int[]{3, 4};

        Solution sol = new Solution();
        int res[] = sol.findRightInterval(intervals);

        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}