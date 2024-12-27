package 平均等待时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public double averageWaitingTime(int[][] customers) {

        double sumWaitTime = 0;
        int n = customers.length;

        int finishTime = customers[0][0];
        for (int i = 0; i < n; i++) {
            int time = customers[i][0];
            int processTime = customers[i][1];

            sumWaitTime += Math.max(0, finishTime - time);
            finishTime = Math.max(finishTime + processTime, time + processTime);
            sumWaitTime += processTime;
        }

        return sumWaitTime / n;
    }
    public static void main(String[] args) {

        int[][] array = {
                {2, 3},
                {6, 3},
                {7, 5},
                {11, 3},
                {15, 2},
                {18, 1}
        };

        Solution sol = new Solution();
        double ret = sol.averageWaitingTime(array);

        System.out.println(ret);
    }
}