package 回旋镖的数量;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public double getDistance(int[]p1, int[]p2) {

        int xAbs = Math.abs(p1[0] - p2[0]);
        int yAbs = Math.abs(p1[1] - p2[1]);

        return Math.sqrt(xAbs * xAbs + yAbs * yAbs);
    }
    public int numberOfBoomerangs(int[][] points) {

        int ret = 0;

        for (int i = 0; i < points.length; i++) {

            int[]midPoint = points[i];
            Map<Double, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                double distance = getDistance(midPoint, points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Double key : map.keySet()) {
                int num = map.get(key);
                if (num > 1) {
                    ret += (num - 1) * num;
                }
            }
        }

        return ret;
    }
    public static void main(String[] args) {

        int[][]points = {{0, 0}, {1, 0}, {2, 0}};

        Solution sol = new Solution();
        int ret = sol.numberOfBoomerangs(points);

        System.out.println(ret);
    }
}



