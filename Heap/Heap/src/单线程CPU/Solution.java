package 单线程CPU;

import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[]res = new int[n];

        int index = 0;

        int[][]allTasks = new int[n][3];
        for (int[]task : tasks) {
            allTasks[index][0] = task[0];
            allTasks[index][1] = task[1];
            allTasks[index][2] = index;
            index++;
        }
        //
        Arrays.sort(allTasks, (a, b)->a[0] - b[0]);
        //
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b)->{
            if (a[1] == b[1]) {
                return a[2] - b[2];
            } else {
                return a[1] - b[1];
            }
        });

        int curEnd = 0;
        index = 0;
        int taskIndex = 0;

        while (taskIndex < n || !pq.isEmpty()) {

            while (taskIndex < n && allTasks[taskIndex][0] <= curEnd) {
                pq.add(allTasks[taskIndex]);
                taskIndex++;
            }

            if (pq.isEmpty()) {
                curEnd = allTasks[taskIndex][0];
            } else {
                int[]tmp = pq.poll();
                res[index++] = tmp[2];
                curEnd += tmp[1];
            }
        }
        //
        return res;
    }

    public static void main(String[] args) {

        int[][] tasks = {
                {19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4},
                {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6},
                {45, 4}, {18, 18}, {46, 39}, {12, 24}
        };

        Solution sol = new Solution();
        int[]res = sol.getOrder(tasks);

        for (Integer order : res){
            System.out.print(order + " ");
        }
        System.out.println();
    }
}
