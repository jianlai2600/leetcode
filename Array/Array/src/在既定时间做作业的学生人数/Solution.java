package 在既定时间做作业的学生人数;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int ret = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[]startTime = {1,2,3}, endTime = {3,2,7};
        int queryTime = 4;

        Solution sol = new Solution();
        int ret = sol.busyStudent(startTime, endTime, queryTime);

        System.out.println(ret);
    }
}