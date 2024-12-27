package 统计好节点的数目;

import java.util.*;

class Solution {
    public int dfs(int node, int father) {

        int curSize = 1;
        int subTreeSize = -1;

        boolean isEqual = true;

        for (Integer son : graph[node]) {
            if (son != father) {
                int size = dfs(son, node);
                if (subTreeSize == -1) {
                    subTreeSize = size;
                } else if (size != subTreeSize) {
                    isEqual = false;
                }

                curSize += size;
            }
        }
        if (isEqual) {
            res++;
        }
        return curSize;
    }
    List<Integer>[]graph;
    int res;
    public int countGoodNodes(int[][] edges) {

        int n = edges.length + 1;
        graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[]edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph[from].add(to);
            graph[to].add(from);
        }
        res = 0;
        dfs(0, -1);
        return res;
    }
    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {0, 5},
                {1, 6},
                {2, 7},
                {3, 8}
        };
        int target = 9;

        Solution sol = new Solution();
        int res = sol.countGoodNodes(edges);

        System.out.println(res);
    }
}



