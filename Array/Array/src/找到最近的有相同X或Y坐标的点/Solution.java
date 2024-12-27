package 找到最近的有相同X或Y坐标的点;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int idx = 0;
        for (int[]point : points) {
            if (point[0] == x || point[1] == y) {
                int dis = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                int[]tmp = new int[2];
                tmp[0] = dis;
                tmp[1] = idx;
                pq.add(tmp);
            }
            idx++;
        }
        if (pq.isEmpty()) {
            return -1;
        }
        return pq.poll()[1];
    }
    public static void main(String[] args) {

        int x = 3;
        int y = 4;
        int[][] points = {
                {1, 2},
                {3, 1},
                {2, 4},
                {2, 3},
                {4, 4}
        };

        Solution sol = new Solution();
        int ret = sol.nearestValidPoint(x, y, points);

        System.out.println(ret);
    }
}