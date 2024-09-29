package 冗余连接2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    class ufs {
        int[]father;
        ufs(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        private int find(int element) {
            if (element != father[element]) {
                father[element] = find(father[element]);
            }
            return father[element];
        }
        public void join(int point1, int point2) {

            int f1 = find(point1);
            int f2 = find(point2);

            if (f1 != f2) {
                father[f2] = f1;
            }
        }
        public boolean isConnected(int point1, int point2) {
            return find(point1) == find(point2);
        }
    }
    public int[] deleteInLoop(ufs u, int[][]edges) {
        for (int[]edge : edges) {
            if (u.isConnected(edge[0], edge[1])) {
                return edge;
            } else {
                u.join(edge[0], edge[1]);
            }
        }
        return new int[2];
    }
    public boolean isValid(ufs u, int[][]edges, int index) {
        for (int i = 0; i < edges.length; i++) {
            if (i == index) {
                continue;
            }
            int[] edge = edges[i];
            if (u.isConnected(edge[0], edge[1])) {
                return false;
            } else {
                u.join(edge[0], edge[1]);
            }
        }
        return true;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = 0;
        for (int[]edge : edges) {
            n = Math.max(Math.max(n, edge[0]), edge[1]);
        }
        ufs u = new ufs(n + 1);
        // calculate in degree
        int[]indegree = new int[n + 1];
        for (int[]edge : edges) {
            indegree[edge[1]]++;
        }
        // case 1: have 2 in order, check whether delete or not
        List<Integer>list = new ArrayList<>();
        for (int i = edges.length - 1; i >= 0; i--) {
            if (indegree[edges[i][1]] == 2) {
                list.add(i);
            }
        }
        if (!list.isEmpty()) {
            if (isValid(u, edges, list.get(0))) {
                return edges[list.get(0)];
            } else {
                return edges[list.get(1)];
            }
        }
        // case 2: have loop
        int[]ret = deleteInLoop(u, edges);
        return ret;
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};

        Solution sol = new Solution();
        int[] ret = sol.findRedundantDirectedConnection(edges);

        for (Integer item : ret) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}


