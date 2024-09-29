package 寻找图中是否存在路径;

import java.util.*;

class Solution {
    class ufs {
        int[]father;
        ufs(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        public int find(int element) {
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
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ufs u = new ufs(n);

        for (int[]edge : edges) {
            u.join(edge[0], edge[1]);
        }
        return u.isConnected(source, destination);
    }
    public static void main(String[] args) {

        int n = 6, source = 0, destination = 5;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        Solution sol = new Solution();
        boolean ret = sol.validPath(n, edges, source, destination);

        System.out.println(ret);
    }
}


