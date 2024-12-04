package 新增道路查询后的最短距离1;

import java.util.*;

class Solution {
    public int bfs(Map<Integer, List<Integer>> graph) {

        Queue<Integer>queue = new LinkedList<>();
        queue.add(0);
        int n = graph.size();
        int[]dist = new int[n];

        for (int i = 1; i < n; i++) {
            dist[i] = -1;
        }

        while (!queue.isEmpty()) {

            int curNode = queue.poll();

            for (Integer neighbor : graph.get(curNode)) {

                if (dist[neighbor] != -1) {
                    continue;
                }
                queue.add(neighbor);
                dist[neighbor] = dist[curNode] + 1;
            }
        }
        return dist[n - 1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            graph.put(i, new ArrayList<>());
            graph.get(i).add(i + 1);
        }
        graph.put(n - 1, new ArrayList<>());

        int len = queries.length;
        int[]res = new int[len];

        int index = 0;
        for (int[]query : queries) {
            int from = query[0];
            int to = query[1];

            graph.get(from).add(to);

            res[index++] = bfs(graph);
        }

        return res;
    }
    public static void main(String[] args) {

        int n = 5;
        int[][] queries = {
                {2, 4},
                {0, 2},
                {0, 4}
        };

        Solution sol = new Solution();
        int[]res = sol.shortestDistanceAfterQueries(n, queries);

        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


