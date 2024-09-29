package 覆盖所有点的最少矩形数目;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {

        int ret = 0;

        Arrays.sort(points, (a, b)->a[0] - b[0]);

        int curRange = 0;
        for (int i = 0; i < points.length; i++) {
            ret++;
            curRange = points[i][0] + w;
            while (i + 1 < points.length && points[i + 1][0] <= curRange) {
                i++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[][] points = {{2,1}, {1,0}, {1,4}, {1,8}, {3,5}, {4,6}};
        int w = 1;

        Solution sol = new Solution();
        int ret = sol.minRectanglesToCoverPoints(points, w);

        System.out.println(ret);
    }
}

