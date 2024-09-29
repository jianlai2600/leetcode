package 最小时间差;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] getTimeArray(String s) {

        int[]ret = new int[2];
        int num1 = Integer.valueOf(s.substring(0, 2));
        int num2 = Integer.valueOf(s.substring(3, 5));

        ret[0] = num1;
        ret[1] = num2;

        return ret;
    }
    public int getDifference(int[]time1, int[]time2) {
        return (time2[0] - time1[0]) * 60 + time2[1] - time1[1];
    }
    public int findMinDifference(List<String> timePoints) {

        int ret = Integer.MAX_VALUE;
        int[][]list = new int[timePoints.size()][2];
        int index = 0;
        int m = list.length;
        for (String s :timePoints) {
            list[index++] = getTimeArray(s);
        }
        //
        Arrays.sort(list, (a, b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int[]preTime = list[0];

        for (int i = 1; i < m; i++) {
            int[]curTime = list[i];
            if (Arrays.equals(curTime, preTime)) {
                return 0;
            }
            int difference = getDifference(preTime, curTime);
            difference = Math.min(difference, 1440 - difference);
            ret = Math.min(ret, difference);

            preTime = curTime;
        }
        //
        int specialCase = getDifference(list[0], list[m - 1]);
        specialCase = Math.min(1440 - specialCase, specialCase);
        ret = Math.min(ret, specialCase);
        return ret;
    }
    public static void main(String[] args) {

        List<String> timePoints = new ArrayList<>();
        timePoints.add("02:39");
        timePoints.add("10:26");
        timePoints.add("21:43");

        Solution sol = new Solution();
        int ret = sol.findMinDifference(timePoints);

        System.out.println(ret);
    }
}