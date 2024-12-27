package 最小高度树;

import java.util.*;

class Solution {
    List<Integer>res;
    int minDepth = Integer.MAX_VALUE;
    int curDepth = 0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return List.of(0);
        }
        Map<Integer, List<Integer>>graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[]edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        int[]degree = new int[n];

        List<Integer>leave = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            degree[i] = graph.get(i).size();
            if (degree[i] == 1) {
                leave.add(i);
            }
        }

        int curNode = n;

        while (curNode > 2) {
            curNode -= leave.size();
            List<Integer>newLeave = new ArrayList<>();

            for (Integer l : leave) {
                for (Integer neighbor : graph.get(l)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        newLeave.add(neighbor);
                    }
                }
            }
            leave = newLeave;
        }

        return leave;
    }
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

        res = new ArrayList<>();

        Map<Integer, List<Integer>>graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[]edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            curDepth = 0;
            bfs(graph, i);
        }

        return res;
    }

    private void bfs(Map<Integer, List<Integer>> graph, int index) {

        Queue<Integer>queue = new LinkedList<>();
        queue.add(index);
        boolean[]visited = new boolean[graph.size()];

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                visited[tmp] = true;

                List<Integer>neighbors = graph.get(tmp);
                if (!neighbors.isEmpty()) {
                    for (Integer neighbor : neighbors) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                        }
                    }
                }
            }

            curDepth++;
        }

        if (curDepth < minDepth) {
            minDepth =curDepth;
            res.clear();
            res.add(index);
        } else if (curDepth == minDepth) {
            res.add(index);
        }
    }

    public static void main(String[] args){

        int n = 6;
        int[][] edges = {
                {3, 0},
                {3, 1},
                {3, 2},
                {3, 4},
                {5, 4}
        };

        Solution sol = new Solution();
        List<Integer> ret = sol.findMinHeightTrees(n, edges);

        for (Integer num : ret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



