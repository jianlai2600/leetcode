package 新增道路查询后的最短距离2;

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int[]roads = new int[n];
        for (int i = 0; i < n; i++) {
            roads[i] = i + 1;
        }
        roads[n - 1] = -1;

        int len = queries.length;
        int[]res = new int[len];

        int index = 0;
        int dis = n - 1;
        for (int i = 0; i < queries.length; i++) {

            int[]query = queries[i];
            int from = query[0];
            int to = query[1];

            int nextStation = roads[from];

            if (to > roads[from]) {
                roads[from] = to;
            }
//            nextStation = roads[from];

            while (nextStation != -1 && nextStation < to) {
                int tmp = roads[nextStation];
                roads[nextStation] = -1;
                nextStation = tmp;
                dis--;
            }

            res[index++] = dis;
        }

        return res;
    }
    public static void main(String[] args) {

        int n = 4;
        int[][] queries = {
                {0, 3},
                {0, 2}
        };

        Solution sol = new Solution();
        int[]res = sol.shortestDistanceAfterQueries(n, queries);

        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


