package 判断二分图;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean bfs(int point, int[][]graph) {

        Queue<Integer>queue = new LinkedList<>();

        queue.add(point);
        color[point] = 1;

        while (!queue.isEmpty()) {

            int curNode = queue.poll();
            int curColor = color[curNode];

            int[]neighbors = graph[curNode];
            for (Integer neighbor : neighbors) {

                if (color[neighbor] == 0) {
                    color[neighbor] = -curColor;
                    queue.add(neighbor);
                } else if (color[neighbor] == curColor) {
                    return false;
                }
            }
        }

        return true;
    }
    int[]color;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                boolean res = bfs(i, graph);
                if (!res) {
                    return res;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[][] graph = {
                {1, 2, 3}, // 节点 0 的邻居
                {0, 2},    // 节点 1 的邻居
                {0, 1, 3}, // 节点 2 的邻居
                {0, 2}     // 节点 3 的邻居
        };

        Solution sol = new Solution();
        boolean res = sol.isBipartite(graph);

        System.out.println(res);
    }
}


