package 安排工作以达到最大收益;

import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int ret = 0, n = difficulty.length, m = worker.length;

        int[][]jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b)->a[0] - b[0]);
        Arrays.sort(worker);

        int index = 0, pro = 0;
        for (int w : worker) {

            while (index < n && w >= jobs[index][0]) {
                pro = Math.max(pro, jobs[index][1]);
                index++;
            }

            ret += pro;
        }

        return ret;
    }
    public static void main(String[] args) {

        int[]difficulty = {2,4,6,8,10}, profit = {10,20,30,40,50},
                worker = {4,5,6,7};

        Solution sol = new Solution();
        int ret = sol.maxProfitAssignment(difficulty, profit, worker);

        System.out.println(ret);
    }
}

