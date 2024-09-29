package 用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {

        int cnt = 1;
        Arrays.sort(points, (a, b)->Integer.compare(a[0], b[0]));

        int start = points[0][0], end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                start = points[i][0];
                end = Math.min(end, points[i][1]);
            } else {
                cnt++;
                start = points[i][0];
                end = points[i][1];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {

        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};

        Solution sol = new Solution();
        int ret = sol.findMinArrowShots(points);

        System.out.println(ret);
    }
}

