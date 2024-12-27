package 网络延迟时间;


import java.util.*;

class Solution {
    int MAX = Integer.MAX_VALUE / 2;
    public int networkDelayTime(int[][] times, int n, int k) {

        int[][]graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], MAX);
        }
        for (int[]time : times) {
            int x = time[0];
            int y = time[1];
            int duration = time[2];
            graph[x - 1][y - 1] = duration;
        }

        int[]dis = new int[n];
        Arrays.fill(dis, MAX);

        dis[k - 1] = 0;
        boolean[]used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = -1;

            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dis[y] < dis[x])) {
                    x = y;
                }
            }
            used[x] = true;

            for (int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + graph[x][y]);
            }
        }
        int ans = Arrays.stream(dis).max().getAsInt();
        return ans == MAX ? -1 : ans;
    }

    public static void main(String[] args) {

        int[][] times = {
                {1, 2, 1},
                {2, 1, 3}
        };
        int n = 2;
        int k = 2;

        Solution sol = new Solution();
        int res = sol.networkDelayTime(times, n, k);

        System.out.println(res);
    }
}


