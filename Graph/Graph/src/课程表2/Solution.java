package 课程表2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[]ret = new int[numCourses];
        int[]inNum = new int[numCourses];

        // Make the graph
        List<List<Integer>>edge = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new LinkedList<>());
        }
        for (int[]info : prerequisites) {
            edge.get(info[1]).add(info[0]);
            inNum[info[0]]++;
        }
        // process
        Queue<Integer>queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inNum[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            ret[index++] = vertex;

            for (int neighbor : edge.get(vertex)) {
                inNum[neighbor]--;
                if (inNum[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return ret;
    }

    public static void main(String[] args){

        int numCourses = 4;
        int prerequisites[][] = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        Solution sol = new Solution();
        int[] ret = sol.findOrder(numCourses, prerequisites);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



